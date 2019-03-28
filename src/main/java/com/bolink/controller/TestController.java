package com.bolink.controller;

import com.alibaba.fastjson.JSON;
import com.bolink.dto.CarTb;
import com.bolink.dto.UnionOrderUnpayNtb;
import com.bolink.service.BolinkOrderSevice;
import com.bolink.service.CarService;
import com.bolink.util.HttpProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.acl.LastOwnerException;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    CarService carService;
    @Autowired
    BolinkOrderSevice bolinkOrderSevice;
    Logger logger = LoggerFactory.getLogger(TestController.class);
    /* @RequestMapping(value = "getcar")
       public String getCar(){
           HttpProxy httpProxy = new HttpProxy();
           String url = "https://price.pcauto.com.cn/api/hcs/select/compareNewBar/serial_brand_json_chooser";
           String result = httpProxy.doGet(url);
           JSONArray j = JSONArray.parseArray(result.replace("var listCompareInfo = ", "").replace(";", ""));
           for(int i =0;i< j.size();i++){
               JSONObject k=(JSONObject) j.get(i);
               Long id = carService.getSeq();
               String name = k.getString("NAME");
               CarTb carTb = new CarTb();
               carTb.setId(id);
               carTb.setName(name);
               carTb.setType(0);
               carTb.setPid(0L);
               int a = carService.insertCarTb(carTb);
               logger.info("保存品牌"+a+name);
               JSONArray list = k.getJSONArray("LIST");
               if(list != null && list.size() >0){
                   for(int m=0;m<list.size();m++){
                       JSONObject jsonObject = (JSONObject) list.get(m);
                       Long sid = carService.getSeq();
                       String sname = jsonObject.getString("NAME");
                       CarTb carTb2 = new CarTb();
                       carTb2.setId(sid);
                       carTb2.setName(sname);
                       carTb2.setType(1);
                       carTb2.setPid(id);
                       int b = carService.insertCarTb(carTb2);
                       logger.info("保存系列"+b);
                       JSONArray list1 = jsonObject.getJSONArray("LIST");
                       if(list1 != null && list1.size()>0){
                           for(int n=0;n<list1.size();n++){
                               JSONObject ob= (JSONObject) list1.get(n);
                               Long tid =carService.getSeq();
                               String tname = ob.getString("NAME");
                               CarTb carTb3 = new CarTb();
                               carTb3.setId(tid);
                               carTb3.setName(tname);
                               carTb3.setType(2);
                               carTb3.setPid(sid);
                               int c = carService.insertCarTb(carTb3);
                               logger.info("保存系列"+c);
                           }

                       }

                   }
               }
           }
           return null;
       }*/
    @RequestMapping(value = "getcarprice")
    public String getCarPrice() throws UnsupportedEncodingException {
        List<CarTb> list = carService.getCarList();
        for (CarTb carTb : list) {
            if (carTb.getType() == 1) {


                HttpProxy httpProxy = new HttpProxy();
                String url = "https://sou.autohome.com.cn/Api/Suggest/search?q=" + URLEncoder.encode(carTb.getName(), "gbk");
                String result = httpProxy.doGet(url);
                try {
                    logger.info(result.substring(result.indexOf("("), result.lastIndexOf(")")));
                    String s = result.substring(result.indexOf("("), result.lastIndexOf(")")).replaceAll("'", "");
                    if (s != null && !"".equals(s)) {
                        String[] split = s.split(":");
                        if (split.length > 4) {
                            String beg = split[2];
                            String end = split[3];
                            String price = beg + "-" + end + "万";
                            logger.info(price);
                            carTb.setPrice(price);
                            int i = carService.updateCar(carTb);
                            logger.info("更新结果：" + i);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @RequestMapping(value = "/getlevel")
    public String getLevel() {
        List<CarTb> carList = carService.getCarList();
        for (CarTb carTb : carList) {
            String price = carTb.getPrice();
            Integer level1 = carTb.getLevel();
            if (price != null && !"".equals(price) && price.contains("-") && level1 == 0) {
                price = price.replace("万", "");
                String[] split = price.split("-");
                if (split.length > 1) {
                    String a = split[0];
                    String b = split[1];
                    Double c = Double.valueOf(a);
                    Double d = Double.valueOf(b);
                    Integer level = 0;
                    if (c < 10) {
                        level = 1;
                    } else if (c < 20 && 10 < c) {
                        level = 2;
                    } else if (c < 30 && 20 < c) {
                        level = 3;
                    } else if (c < 40 && 30 < c) {
                        level = 4;
                    } else if (c < 50 && 40 < c) {
                        level = 5;
                    } else if (c < 60 && 50 < c) {
                        level = 6;
                    } else if (c > 60) {
                        level = 7;
                    } else {
                        logger.info("没有找到档位{},{}", a, b);
                    }
                    logger.info("匹配的档位{},{},{}", a, b, level);
                    carTb.setLevel(level);
                    int i = carService.updateCarLevel(carTb);
                    logger.info("档位更新结果：" + i);
                }
            }
        }
        return null;
    }
    @RequestMapping("testapi")
    public void test (){
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>");

        try {
            List<UnionOrderUnpayNtb> orderList = bolinkOrderSevice.getOrderList();
            logger.info("result:"+ JSON.toJSONString(orderList));

            Long seq = carService.getSeq();

            logger.info("result2:"+seq);
        } catch (Exception e) {
            logger.info("excetion:",e);
        }
    }
}
