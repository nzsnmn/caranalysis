package com.bolink.mapper.bolinkdb;

import com.bolink.dto.CarTb;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UnionParkTbMapper {

    @Select("select id from union_park_tb where union_id = #{unionId} and park_id = #{parkId} limit 1")
    Long  getComidByUnionIdAndParkId(@Param("unionId") Long unionId,@Param("parkId")String parkId);

}
