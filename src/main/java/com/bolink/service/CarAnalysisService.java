package com.bolink.service;

import com.alibaba.fastjson.JSONObject;
import com.bolink.dto.CarAnalysisResultTb;
import com.bolink.vo.CarTypeInfoVo;
import com.bolink.vo.TxCarAiResult;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarAnalysisService {

   List<CarTypeInfoVo> getCarType(Integer pageNumber, Integer pageSize);

   int getCarTypeCount();

   boolean insertCarInfo(Long parkId, String orderId, String plateNumber, JSONObject jsonObject,String picUrl);

   JSONObject getCarTypeByPlateNumber(String plateNumber);

   CarAnalysisResultTb getCarAnalysisPlateNumber(String plateNumber);

   boolean insertCarInfoTx(Long unionId,String parkId, String orderId, String plateNumber, TxCarAiResult txCarAiResult, String picUrl);

   boolean isCarAnalysised(String plateNumer);
}
