package com.bolink.mapper.addb;

import com.bolink.dto.CarTb;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarTbMapper {
    @Insert("insert into car_tb(id,name,type,pid) values(#{id},#{name},#{type},#{pid})")
    int insertCarTb(CarTb carTb);
    @Select("select nextval('car_tb_seq')")
    Long getSeq();
    @Select("select * from car_tb where type =1")
    List<CarTb> getCarList();
    @Update("update car_tb set price = #{price} where id=#{id}")
    int updateCar(CarTb carTb);
    @Update("update car_tb set level = #{level} where id=#{id}")
    int updateCarLevel(CarTb carTb);
    @Select("select * from car_tb where name = #{type} limit 1")
    CarTb getCarByType(@Param("type") String type);
    @Select("select * from car_tb where name like #{type}")
    List<CarTb> getCarByTypeLike(@Param("type") String type);
}
