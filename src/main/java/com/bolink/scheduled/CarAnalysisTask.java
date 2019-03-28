package com.bolink.scheduled;

import com.alibaba.fastjson.JSONObject;
import com.bolink.dto.CarAnalysisResultTb;
import com.bolink.dto.OrderTb;
import com.bolink.dto.UnionOrderUnpayNtb;
import com.bolink.service.BolinkOrderSevice;
import com.bolink.service.CarAnalysisService;
import com.bolink.service.OrderService;
import com.bolink.util.HttpProxy;
import com.bolink.util.StringUtils;
import com.bolink.util.baidu.AuthService;
import com.bolink.util.baidu.HttpUtil;
import com.bolink.util.tencentai.TencentAiClient;
import com.bolink.vo.TxCarAiResult;
import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.net.URLEncoder;
import java.util.List;

@Component
public class CarAnalysisTask {
    @Autowired
    OrderService orderService;
    @Autowired
    CarAnalysisService carAnalysisService;
    @Autowired
    MemCachedClient memCachedClient;

    @Autowired
    BolinkOrderSevice bolinkOrderSevice;

    Logger logger = LoggerFactory.getLogger(CarAnalysisTask.class);

    private static int num = 0;
    private static int apicount = 0;
//    @Scheduled(cron = "0 5 9 ? * *")
    public void resetCount(){
        apicount=0;
        logger.info("调百度api次数={}",apicount);
    }

    /**
     * 0-6点每半小时
     *
     * @throws Exception
     */
//    @Scheduled(cron = "0 0/30 0-6 * * ?")
//   @Scheduled(cron = "0 0/5 9-20 * * ?")
    public void scheduled01() throws Exception {
        logger.info("sheduled start ..........");
        if(apicount >500){
            return;
        }
//        num = num + 1;
        List<OrderTb> orderList = orderService.getOrderList(num * 50);
        logger.info("订单总数：{}" ,orderList.size());
        for (OrderTb orderTb :
                orderList) {
            Thread.sleep(1000);
            String orderId = orderTb.getOrder_id_local();
            Long parkId = orderTb.getComid();
            String plateNumber = orderTb.getCar_number();
            logger.info("parkId={},orderId={},plateNumber={}",parkId , orderId ,plateNumber);
            Integer state = (Integer) memCachedClient.get(StringUtils.MD5(plateNumber));
           logger.info("取缓存结果：{}" , state);
            if(state !=null && state != 0){
                System.out.print("back /n");
                continue;
            }
          /*  Integer isHavePic = (Integer) memCachedClient.get(parkId+"-"+orderId);
            if(isHavePic != null&&isHavePic==1){
                 logger.info("no pic back");
                 continue;
            }*/
            HttpProxy httpProxy = new HttpProxy();
            String result = "";
            String getPicUrl = "http://yun.bolink.club/zld/carpicsup.do?action=getpicapi&comid=" + parkId + "&orderid=" + orderId + "&typeNew=in";
            result = httpProxy.doGet(getPicUrl);


            JSONObject retJson = JSONObject.parseObject(result);
            if (retJson == null) {
                continue;
            }
           /* if ((Integer) retJson.get("state") == 0) {
                logger.info("no picture");
                memCachedClient.set(parkId+"-"+orderId,1,60*10);
                continue;
            }*/
          /*  byte[] imgData = (byte[]) retJson.get("content");
            String imgStr = Base64Util.encode(imgData);*/
            String imgStr = (String) retJson.get("content");
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam + "&top_num=" + 5 + "&baike_num=5";            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
            // 客户端可自行缓存，过期后重新获取。
            String accessToken = "";
            if (memCachedClient.get("baiduaitoken") != null) {
                accessToken = (String) memCachedClient.get("baiduaitoken");
            } else {
                accessToken = AuthService.getAuth();
                memCachedClient.set("baiduaitoken", accessToken, 60 * 60);
            }
            String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car";
            if (result != null && !"".equals(result) && state == null) {
//            if(true){
                String baiduResult = HttpUtil.post(url, accessToken, param);
                JSONObject baiduretJson = JSONObject.parseObject(baiduResult);
                if(baiduretJson.containsKey("error_code") ){
                    Integer errorCode = baiduretJson.getInteger("error_code");
                    logger.info("调用百度接口错误{}",errorCode);
                    if(errorCode ==17 || errorCode == 18 || errorCode == 19){
                        apicount= 501;
                        logger.info("调用百度api已超过上限");
                        break;
                    }
                }
                boolean b = carAnalysisService.insertCarInfo(parkId, orderId, plateNumber, JSONObject.parseObject(baiduResult),"");
                logger.info("车型识别数据保存结果：{}" , b);
                memCachedClient.set(StringUtils.MD5(plateNumber), 1, 60 * 60 * 24 * 90);
                apicount= apicount+1;
            }

        }
    }

    /**
     * 腾讯车型分析
     */
//    @Scheduled(cron = "0 0/1 9-22 * * ?")
    public void tencentCarClassifyTask(){
        logger.info(">>>>>>>>>>>>>>>>>>>>"+"开始进行腾讯车辆分析");
        try {
            List<UnionOrderUnpayNtb> orderList = bolinkOrderSevice.getOrderList();
            if(orderList != null && orderList.size() > 0){
                for (UnionOrderUnpayNtb unionOrderUnpayNtb:orderList) {
                    String picUrl = unionOrderUnpayNtb.getPicUrl();
                    Long unionId = unionOrderUnpayNtb.getUnionId();
                    String parkId = unionOrderUnpayNtb.getParkId();
                    String orderId = unionOrderUnpayNtb.getOrderId();
                    String plateNumber = unionOrderUnpayNtb.getPlateNumber();

                    //查询数据库是否分析过
                    CarAnalysisResultTb carTypeByPlateNumber = carAnalysisService.getCarAnalysisPlateNumber(plateNumber);
                    if(carTypeByPlateNumber != null){
                        logger.info("已经分析过此车牌");
                      continue;
                    }
                    //调用腾讯图形分析接口
                    TxCarAiResult txCarAiResult = TencentAiClient.carAnalysis(picUrl);
                    boolean b = carAnalysisService.insertCarInfoTx(unionId,parkId, orderId, plateNumber, txCarAiResult,picUrl);
                    logger.info("车型识别数据保存结果：{}" , b);
                    memCachedClient.set(StringUtils.MD5(plateNumber), 1);
                }
            }
        } catch (Exception e) {
            logger.info("腾讯车型识别处理异常",e);
        }
    }

}
