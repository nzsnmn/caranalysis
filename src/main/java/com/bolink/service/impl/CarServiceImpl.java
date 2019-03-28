package com.bolink.service.impl;

import com.bolink.dto.CarTb;
import com.bolink.mapper.addb.CarTbMapper;
import com.bolink.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED ,transactionManager = "adDataSourceTransactionManager")
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarTbMapper carTbMapper;
    @Override
    public int insertCarTb(CarTb carTb) {
        return carTbMapper.insertCarTb(carTb);
    }

    @Override
    public Long getSeq() {
        return carTbMapper.getSeq();
    }

    @Override
    public List<CarTb> getCarList() {
        return carTbMapper.getCarList();
    }

    @Override
    public int updateCar(CarTb carTb) {
        return carTbMapper.updateCar(carTb);
    }

    @Override
    public int updateCarLevel(CarTb carTb) {
        return carTbMapper.updateCarLevel(carTb);
    }
}
