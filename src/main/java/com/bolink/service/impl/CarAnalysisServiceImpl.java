package com.bolink.service.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bolink.dto.CarAnalysisResultTb;
import com.bolink.dto.CarAnalysisTb;
import com.bolink.dto.CarTb;
import com.bolink.mapper.addb.CarAnalysisMapper;
import com.bolink.mapper.addb.CarTbMapper;
import com.bolink.mapper.bolinkdb.UnionParkTbMapper;
import com.bolink.service.CarAnalysisService;
import com.bolink.util.SnowFlakeIdUtil;
import com.bolink.vo.CarTag;
import com.bolink.vo.CarTypeInfoVo;
import com.bolink.vo.TxCarAiResult;
import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,transactionManager = "adDataSourceTransactionManager" ,rollbackFor =Exception.class)
@Service
public class CarAnalysisServiceImpl implements CarAnalysisService {
    @Autowired
    CarAnalysisMapper carAnalysisMapper;
    @Autowired
    CarTbMapper carTbMapper;
    @Autowired
    UnionParkTbMapper unionParkTbMapper;
    @Autowired
    MemCachedClient memCachedClient;
    Logger logger = LoggerFactory.getLogger(CarAnalysisServiceImpl.class);
    @Override
    public List<CarTypeInfoVo> getCarType(Integer pageNumber, Integer pageSize) {
        Integer offset = 0;
        if(pageNumber >0)
        offset=(pageNumber-1)*pageSize;
        return carAnalysisMapper.getCarTypeInfoList(offset,pageSize);
    }

    @Override
    public int getCarTypeCount() {
        return carAnalysisMapper.getCarTypeInfoCount();
    }

    @Override
    public boolean insertCarInfo(Long parkId, String orderId, String plateNumber, JSONObject jsonObject,String picUrl) {
        boolean flag = true;
        CarAnalysisTb carAnalysisTb = new CarAnalysisTb();
        Long cid = SnowFlakeIdUtil.getInstance().nextId(1);
        String logId = jsonObject.getString("log_id");
        String colorResult = jsonObject.getString("color_result");
        JSONArray result = jsonObject.getJSONArray("result");
        carAnalysisTb.setLog_id(logId);
        carAnalysisTb.setId(cid);
        carAnalysisTb.setColor_result(colorResult);
        carAnalysisTb.setOrder_id(orderId);
        carAnalysisTb.setAnalysis_state(1);
        carAnalysisTb.setPark_id(null);
        carAnalysisTb.setPlate_number(plateNumber);
        carAnalysisTb.setPic_url(picUrl);
        int i1 = carAnalysisMapper.insertCarAnalysisTb(carAnalysisTb);
        logger.info("保存carAnalysisTb结果："+i1);
        if(result !=null && result.size()>0 ) {
            for (int i = 0; i < result.size(); i++) {
                CarAnalysisResultTb carAnalysisResultTb = new CarAnalysisResultTb();
                Long rid = SnowFlakeIdUtil.getInstance().nextId(2);
                carAnalysisResultTb.setId(rid);
                JSONObject resJson = (JSONObject) result.get(i);
                JSONObject baike_info = resJson.getJSONObject("baike_info");
                if (baike_info != null) {
                    String baike_url = baike_info.getString("baike_url");
                    String description = baike_info.getString("description");
                    String image_url = baike_info.getString("image_url");
                    carAnalysisResultTb.setImgUrl(image_url);
                    carAnalysisResultTb.setBaikeUrl(baike_url);
                    carAnalysisResultTb.setDescription(description);
                }
                Double score = resJson.getDouble("score");
                String name = resJson.getString("name");
                String year = resJson.getString("year");
                carAnalysisResultTb.setName(name);
                carAnalysisResultTb.setScore(BigDecimal.valueOf(score));
                carAnalysisResultTb.setSerialNo(i + 1);
                carAnalysisResultTb.setYear(year);
                carAnalysisResultTb.setLogId(logId);
                carAnalysisResultTb.setPlateNumber(plateNumber);
                int i2 = carAnalysisMapper.insertCarAnalysisResultTb(carAnalysisResultTb);
                logger.info("保存carAnalysisResultTb结果：" + i2);
            }
        }
        return flag;
    }

    @Override
    public JSONObject getCarTypeByPlateNumber(String plateNumber) {
        JSONObject retJson = new JSONObject();
        String carType = "";
        String year = "";
        //报价区间
        String price="";
        //档位
        Integer level=0;
        //先取缓存数据
        String carInfo = (String) memCachedClient.get("carinfo" + plateNumber.hashCode());
        if(carInfo != null && !"".equals(carInfo)){
            return JSONObject.parseObject(carInfo);
        }
        CarAnalysisResultTb carAnalysisResultTb = getCarAnalysisPlateNumber(plateNumber);
        if(carAnalysisResultTb != null){
            logger.info("car type is "+carAnalysisResultTb.getName());
            //车型
            carType = carAnalysisResultTb.getName();
            //年份
            year = carAnalysisResultTb.getYear();
            //
            CarTb carTb = carTbMapper.getCarByType(carType);
            if(carTb != null){
                price = carTb.getPrice();
                level = carTb.getLevel();
                logger.info("精准查询到结果：{}{}",price,level);
            }else{
                //如果查不到则进行模糊查询 --截取车型后两位
                List<CarTb> carByTypeLike = carTbMapper.getCarByTypeLike("%" + carType.substring(carType.length() - 2) + "%");
                if(carByTypeLike != null && carByTypeLike.size() >0){
                    w:for(CarTb carTb1:carByTypeLike){
                        price = carTb1.getPrice();
                        level = carTb1.getLevel();
                        if(price !=null && !"".equals(price) && price.contains("万")){
                            logger.info("模糊匹配到数据{}{}",price,level);
                            break w;
                        }
                    }

                }else{
                    //用车型后两位模糊查询
                    List<CarTb> carByTypeLike2 = carTbMapper.getCarByTypeLike("%"+carType.substring(0,2)+"%");
                    if(carByTypeLike2 != null && carByTypeLike2.size() >0) {
                       w: for (CarTb carTb1 : carByTypeLike2) {
                            price = carTb1.getPrice();
                            level = carTb1.getLevel();
                            if (price != null && !"".equals(price) && price.contains("万")) {
                                logger.info("模糊匹配到数据{}{}",price,level);
                                break w;
                            }
                        }
                    }
                }
            }
        }else {
            return null;
        }
        retJson.put("car_type",carType);
        retJson.put("year",year);
        //level大于0 说明已经找到数据
        if(level>0){
            retJson.put("price",price);
            retJson.put("level",level);
            //把车牌所查出的车型数据存缓存
            boolean set = memCachedClient.set("carinfo" + plateNumber.hashCode(), retJson.toString(), 60 * 60 * 24 * 10);
            logger.info("车牌号:{},存数据缓存结果:{}",plateNumber,set);
        }
        return retJson;
    }
    @Override
    public CarAnalysisResultTb getCarAnalysisPlateNumber(String plateNumber){
        String car = (String) memCachedClient.get("cartype"+plateNumber.hashCode());
        logger.info("从缓存中取到的车型识别数据:{}",car);
        if(car != null && !"".equals(car) && !"null".equals(car)){
            CarAnalysisResultTb carAnalysisResultTb = JSON.parseObject(car,CarAnalysisResultTb.class);
            return  carAnalysisResultTb;
        }else {
            CarAnalysisResultTb carAnalysisResultTb = carAnalysisMapper.getCarTypeByPlateNumber(plateNumber);
            if(carAnalysisResultTb == null){
                return null;
            }
            logger.info("从数据库取的识别数据："+JSON.toJSONString(carAnalysisResultTb));
            boolean set = memCachedClient.set("cartype" + plateNumber.hashCode(), JSON.toJSONString(carAnalysisResultTb), 24 * 60 * 60 * 10);
            logger.info("存车牌号{}缓存,识别数据结果{}",plateNumber,set);
            return carAnalysisResultTb;
        }
    }

    @Override
    public boolean insertCarInfoTx(Long unionId,String parkId, String orderId, String plateNumber, TxCarAiResult txCarAiResult, String picUrl) {
        boolean flag = true;
        try {

            List<CarTag> result = txCarAiResult.getTags();
            if(result !=null && result.size()>0 ) {
                CarAnalysisTb carAnalysisTb = new CarAnalysisTb();
                Long cid = SnowFlakeIdUtil.getInstance().nextId(1);
                String logId = cid+"";
//                Long comid = unionParkTbMapper.getComidByUnionIdAndParkId(unionId,parkId);
                carAnalysisTb.setLog_id(logId);
                carAnalysisTb.setId(cid);
                carAnalysisTb.setColor_result(null);
                carAnalysisTb.setOrder_id(orderId);
                carAnalysisTb.setAnalysis_state(1);
                carAnalysisTb.setPark_id(parkId);
                carAnalysisTb.setPlate_number(plateNumber);
                carAnalysisTb.setPic_url(picUrl);
                int i1 = carAnalysisMapper.insertCarAnalysisTb(carAnalysisTb);
                logger.info("保存carAnalysisTb结果："+i1);

                List<CarAnalysisResultTb> list = new ArrayList<CarAnalysisResultTb>();
                for (int i = 0; i < result.size(); i++) {
                    CarAnalysisResultTb carAnalysisResultTb = new CarAnalysisResultTb();
                    Long rid = SnowFlakeIdUtil.getInstance().nextId(2);
                    carAnalysisResultTb.setId(rid);
                    CarTag carTag = result.get(i);

                    Double score = carTag.getConfidence();
                    String name = carTag.getSerial();
                    String year = null;
                    carAnalysisResultTb.setName(name);
                    carAnalysisResultTb.setScore(BigDecimal.valueOf(score));
                    carAnalysisResultTb.setSerialNo(i + 1);
                    carAnalysisResultTb.setYear(year);
                    carAnalysisResultTb.setLogId(logId);
                    carAnalysisResultTb.setPlateNumber(plateNumber);
                    carAnalysisResultTb.setColor(carTag.getColor());
                    carAnalysisResultTb.setBrand(carTag.getBrand());
                    list.add(carAnalysisResultTb);
    //                int i2 = carAnalysisMapper.insertCarAnalysisResultTb(carAnalysisResultTb);
    //                logger.info("保存carAnalysisResultTb结果：" + i2);
                }
                if(list != null && list.size() >0){
                    int i = carAnalysisMapper.insertCarAnalysisResutTbList(list);
                   logger.info("保存carAnalysisResultTb结果：" + i);

                }
            }
        } catch (Exception e) {
           throw new RuntimeException("保存数据异常");
        }
        return flag;
    }

    @Override
    public boolean isCarAnalysised(String plateNumer) {
        Integer carAnalysis = carAnalysisMapper.getCarAnalysis(plateNumer);
        if(carAnalysis >0){
            return true;
        }
        return false;
    }
}
