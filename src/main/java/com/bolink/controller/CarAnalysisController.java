package com.bolink.controller;

import com.alibaba.fastjson.JSONObject;
import com.bolink.dto.CarAnalysisResultTb;
import com.bolink.service.CarAnalysisService;
import com.bolink.service.CarService;
import com.bolink.util.CheckUtil;
import com.bolink.util.CreateImgUtil;
import com.bolink.util.HttpProxy;
import com.bolink.util.StringUtils;
import com.bolink.util.baidu.AuthService;
import com.bolink.util.Base64Util;
import com.bolink.util.baidu.HttpUtil;
import com.bolink.util.tencentai.TencentAiClient;
import com.bolink.vo.CarTypeInfoVo;
import com.bolink.vo.TxCarAiResult;
import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.List;

@RestController
public class CarAnalysisController {
    @Autowired
    CarAnalysisService carAnalysisService;
    @Autowired
    CarService carService;
    @Autowired
    MemCachedClient memCachedClient;
    Logger logger = LoggerFactory.getLogger(CarAnalysisController.class);

    @RequestMapping(value = "/getcartype")
    public String getCarTypeInfo(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize) {
        JSONObject retJSON = new JSONObject();
        logger.info("pageNumber={},pageSize={}", pageNumber, pageSize);
        if (pageNumber == null || pageNumber == 0) {
            pageNumber = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 20;
        }
        String imgurl = "http://yun.bolink.club/zld/carpicsup.do?action=getpic&typeNew=in";
        retJSON.put("count", 0);
        retJSON.put("list", "");
        retJSON.put("pageNumber", pageNumber);
        retJSON.put("pageSize", pageSize);
        try {
            int carTypeCount = carAnalysisService.getCarTypeCount();
            logger.info("数量:{}", carTypeCount);
            List<CarTypeInfoVo> carType = carAnalysisService.getCarType(pageNumber, pageSize);
            for (CarTypeInfoVo carTypeInfoVo :
                    carType) {
                if(carTypeInfoVo.getImgUrl() == null || "".equals(carTypeInfoVo.getImgUrl() == null))
                carTypeInfoVo.setImgUrl(imgurl + "&comid=" + carTypeInfoVo.getParkId() + "&orderid=" + carTypeInfoVo.getOrderId());
            }
            logger.info("订单数量：{}，页码：{},每页数量：{}", carType.size(), pageNumber, pageSize);
            retJSON.put("list", carType);
            retJSON.put("count", carTypeCount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retJSON.toJSONString();
    }

    /**
     * 车型识别接口
     *
     * @param parkId
     * @param plateNumber
     * @param orderId
     * @param type
     * @return
     */
    @RequestMapping(value = "caranalysis")
    public String carAnalysis(String parkId, String plateNumber, String orderId, String type, String picUrl) {
        JSONObject resJson = new JSONObject();
        resJson.put("state", 0);
        logger.info("parkId={},orderId={},plateNumber={}", parkId, orderId, plateNumber);
        try {
            Integer state = (Integer) memCachedClient.get(StringUtils.MD5(plateNumber));
            logger.info("取缓存结果：{}", state);
            if (state != null && state != 0) {
                resJson.put("state", 1);
                resJson.put("result_msg", "success!");
                return resJson.toJSONString();
            }
            if (!CheckUtil.isLong(parkId)) {
                resJson.put("state", 0);
                resJson.put("result_msg", "it is not a cloud park for parkId is not long!");
                return resJson.toJSONString();
            }
            //查询数据库是否分析过
            CarAnalysisResultTb carTypeByPlateNumber = carAnalysisService.getCarAnalysisPlateNumber(plateNumber);
            if(carTypeByPlateNumber != null){
                resJson.put("state", 1);
                resJson.put("result_msg", "the car already analysis");
                return resJson.toJSONString();
            }
            Integer isHavePic = (Integer) memCachedClient.get(parkId + "-" + orderId);
            if (isHavePic != null && isHavePic == 1) {
                resJson.put("state", 0);
                resJson.put("result_msg", "no inpark picture!");
                return resJson.toJSONString();
            }
            String imgParam = "";
            if (picUrl != null && !"".equals(picUrl) && picUrl.startsWith("http")) {
                logger.info("图片url：{}", picUrl);
                //有图片url时
                byte[] imageFromNetByUrl = CreateImgUtil.getImageFromNetByUrl(picUrl);
                imgParam = URLEncoder.encode(Base64Util.encode(imageFromNetByUrl), "UTF-8");

            } else {
                //没有图片url直接去云平台获取
                picUrl = "http://yun.bolink.club/zld/carpicsup.do?action=getpic&typeNew=in&comid=" + parkId + "&orderid=" + orderId;
                HttpProxy httpProxy = new HttpProxy();
                String getPicUrl = "http://yun.bolink.club/zld/carpicsup.do?action=getpicapi&comid=" + parkId + "&orderid=" + orderId + "&typeNew=in";
                String result = httpProxy.doGet(getPicUrl);
                JSONObject retJson = JSONObject.parseObject(result);
                if (retJson == null) {
                    resJson.put("state", 0);
                    resJson.put("result_msg", "no inpark picture!");
                    return resJson.toJSONString();
                }
                if ((Integer) retJson.get("state") == 0) {
                    logger.info("no picture");
                    memCachedClient.set(parkId + "-" + orderId, 1, 60 * 10);
                    resJson.put("state", 0);
                    resJson.put("result_msg", "no inpark picture!");
                    return resJson.toJSONString();
                }
                String imgStr = (String) retJson.get("content");
                imgParam = URLEncoder.encode(imgStr, "UTF-8");
            }

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
            String baiduResult = HttpUtil.post(url, accessToken, param);
            logger.info(baiduResult);
            JSONObject baiduretJson = JSONObject.parseObject(baiduResult);
            if (baiduretJson.containsKey("error_code")) {
                Integer errorCode = baiduretJson.getInteger("error_code");
                logger.info("调用百度接口错误{}", errorCode);
                if (errorCode == 17 || errorCode == 18 || errorCode == 19) {
                    logger.info("调用百度api已超过上限");
                    resJson.put("state", 0);
                    resJson.put("result_msg", "bai du api is full!");
                    return resJson.toJSONString();
                }
            }
            boolean b = carAnalysisService.insertCarInfo(Long.valueOf(parkId), orderId, plateNumber, JSONObject.parseObject(baiduResult), picUrl);
            logger.info("车型识别数据保存结果：{}", b);
            memCachedClient.set(StringUtils.MD5(plateNumber), 1);
            if (b) {
                resJson.put("state", 1);
                resJson.put("result_msg", "success!");
                return resJson.toJSONString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resJson.toJSONString();
    }

    /**
     * 根据车牌获取车型数据
     *
     * @param plateNumber
     * @return
     */
    @RequestMapping(value = "/getcartypebypn", produces = "application/json;charset=utf-8")
    public String getCarTypeByPlateNumber(@RequestParam("plateNumber") String plateNumber) {
        logger.info("传入的车牌为：{}", plateNumber);
        JSONObject retJSon = new JSONObject();
        retJSon.put("state", 0);
        retJSon.put("msg", "fail");
        try {
            JSONObject ret = carAnalysisService.getCarTypeByPlateNumber(plateNumber);
            if(ret != null){
                retJSon.put("state", 1);
                retJSon.put("msg", "success");
                retJSon.put("data", ret);
            }else {
                retJSon.put("msg", "no car info");
            }
        } catch (Exception e) {
            logger.info("根据车牌获取报价异常", e);
        }
        return retJSon.toJSONString();
    }

    /**
     * 车型识别接口
     *
     * @param parkId
     * @param plateNumber
     * @param orderId
     * @param type
     * @return
     */
    @RequestMapping(value = "caranalysisyun")
    public String carAnalysisForyun(String parkId, String plateNumber, String orderId, String type, String picUrl) {
        JSONObject resJson = new JSONObject();
        resJson.put("state", 0);
        logger.info("parkId={},orderId={},plateNumber={},picUrl={}", parkId, orderId, plateNumber,picUrl);
        try {

            //查询数据库是否分析过
            boolean flag = carAnalysisService.isCarAnalysised(plateNumber);
            if(flag){
                resJson.put("state", 1);
                resJson.put("result_msg", "the car already analysis");
                return resJson.toJSONString();
            }
            //调用腾讯图形分析接口
            TxCarAiResult txCarAiResult = TencentAiClient.carAnalysis(picUrl);
            boolean b = carAnalysisService.insertCarInfoTx(null,parkId, orderId, plateNumber, txCarAiResult,picUrl);
            logger.info("车型识别数据保存结果：{}" , b);
            if(b){
                resJson.put("state", 1);
                resJson.put("errmsg", "success");
            }
            memCachedClient.set(StringUtils.MD5(plateNumber), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resJson.toJSONString();
    }


}
