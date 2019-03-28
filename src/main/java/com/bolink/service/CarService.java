package com.bolink.service;

import com.bolink.dto.CarTb;

import java.util.List;

public interface CarService {
    int insertCarTb(CarTb carTb);
    Long getSeq();
    List<CarTb> getCarList();
    int updateCar(CarTb carTb);
    int updateCarLevel(CarTb carTb);
}
