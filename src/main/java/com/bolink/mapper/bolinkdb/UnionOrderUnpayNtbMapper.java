package com.bolink.mapper.bolinkdb;


import com.bolink.dto.UnionOrderUnpayNtb;
import com.bolink.dto.UnionOrderUnpayNtbExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnionOrderUnpayNtbMapper {
    int countByExample(UnionOrderUnpayNtbExample example);

    int deleteByExample(UnionOrderUnpayNtbExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UnionOrderUnpayNtb record);

    int insertSelective(UnionOrderUnpayNtb record);

    List<UnionOrderUnpayNtb> selectByExample(UnionOrderUnpayNtbExample example);

    UnionOrderUnpayNtb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UnionOrderUnpayNtb record, @Param("example") UnionOrderUnpayNtbExample example);

    int updateByExample(@Param("record") UnionOrderUnpayNtb record, @Param("example") UnionOrderUnpayNtbExample example);

    int updateByPrimaryKeySelective(UnionOrderUnpayNtb record);

    int updateByPrimaryKey(UnionOrderUnpayNtb record);
}