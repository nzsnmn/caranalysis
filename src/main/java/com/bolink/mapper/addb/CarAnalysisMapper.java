package com.bolink.mapper.addb;

import com.bolink.dto.CarAnalysisResultTb;
import com.bolink.dto.CarAnalysisTb;
import com.bolink.vo.CarTypeInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CarAnalysisMapper {
    @Insert("insert into car_analysis_tb (id,park_id,plate_number,order_id,analysis_state,log_id,color_result,pic_url) values(#{id},#{park_id},#{plate_number},#{order_id},#{analysis_state},#{log_id},#{color_result},#{pic_url})")
    int insertCarAnalysisTb(CarAnalysisTb carAnalysisTb);
    @Insert("insert into car_analysis_result_tb (id,log_id,plate_number,score,name,year,serial_no,description,baike_url,img_url,color,brand) values(#{id},#{logId},#{plateNumber},#{score},#{name},#{year},#{serialNo},#{description},#{baikeUrl},#{imgUrl},#{color},#{brand})")
    int insertCarAnalysisResultTb(CarAnalysisResultTb carAnalysisResultTb);
    @Select("select t1.order_id orderId,t1.park_id parkId,t2.log_id logId,t2.plate_number plateNumber,t2.score score,t2.name as name,t2.year as year,t2.serial_no serialNo,t2.description description,t2.baike_url baikeUrl,t1.pic_url imgUrl from car_analysis_tb t1 left join car_analysis_result_tb t2 on t1.log_id =t2.log_id where t2.serial_no =1 limit #{pageSize} offset #{pageNumber}")
    List<CarTypeInfoVo> getCarTypeInfoList(@Param("pageNumber") Integer pageNumber,@Param("pageSize") Integer pageSize);
    @Select("select count(*) from car_analysis_tb t1 left join car_analysis_result_tb t2 on t1.log_id =t2.log_id where t2.serial_no =1 ")
    int getCarTypeInfoCount();
    @Select("select * from car_analysis_result_tb where plate_number = #{plateNumber} and serial_no =1 limit 1")
    CarAnalysisResultTb getCarTypeByPlateNumber(@Param("plateNumber") String plateNumer);

    @Select("select count(*) from car_analysis_tb where plate_number = #{plateNumber}")
    Integer getCarAnalysis(@Param("plateNumber") String plateNumer);
    @Insert({
            "<script>",
            "insert into car_analysis_result_tb (id,log_id,plate_number,score,name,year,serial_no,description,baike_url,img_url,color,brand) values ",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.id},#{item.logId},#{item.plateNumber},#{item.score},#{item.name},#{item.year},#{item.serialNo},#{item.description},#{item.baikeUrl},#{item.imgUrl},#{item.color},#{item.brand})",
            "</foreach>",
            "</script>"
    })
    int insertCarAnalysisResutTbList(@Param("list") List<CarAnalysisResultTb> list);

}
