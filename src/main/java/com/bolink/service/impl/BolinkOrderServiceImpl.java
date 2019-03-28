package com.bolink.service.impl;

import com.bolink.dto.UnionOrderUnpayNtb;
import com.bolink.dto.UnionOrderUnpayNtbExample;
import com.bolink.mapper.bolinkdb.UnionOrderUnpayNtbMapper;
import com.bolink.service.BolinkOrderSevice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED,transactionManager = "adDataSourceTransactionManager")
@Service
public class BolinkOrderServiceImpl implements BolinkOrderSevice {
    @Autowired
    UnionOrderUnpayNtbMapper unionOrderUnpayNtbMapper;
    @Override
    public List<UnionOrderUnpayNtb> getOrderList() {
        UnionOrderUnpayNtbExample example = new UnionOrderUnpayNtbExample();

        example.createCriteria().andPicUrlIsNotNull();

        example.setOrderByClause(" record_time desc");

        PageHelper.startPage(0,50);

        return unionOrderUnpayNtbMapper.selectByExample(example);

    }
}
