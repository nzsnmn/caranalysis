package com.bolink.service.impl;


import com.bolink.dto.OrderTb;
import com.bolink.mapper.addb.OrderMapper;
import com.bolink.service.OrderService;
import com.bolink.util.OrmUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//
@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Override
    /*
    * 优惠券根据车牌查询这个车场下面的在场订单
    *
    * */
    public OrderTb qryUnPayOrderByCar(String carNumber, Long comid) {
        Long cityid = getCityId(comid);
//        logger.info("select groupid by"+comid+"~~~"+groupid);
        OrderTb orderTb = new OrderTb();
        orderTb.setCar_number(carNumber);
        orderTb.setComid(comid);
        if(cityid>-1){
            orderTb.setTableName("order_tb_new_"+cityid%100);
        }else{
            orderTb.setTableName("order_tb_new");
        }
//        orderTb.setCityid(cityid);
        Map<String,Object> orderMap = orderMapper.qryUnPayOrderByCar(orderTb);
//        logger.debug("test~~~~~~"+orderMap);
        if(orderMap==null){//如果根据车牌精确查询没有查到，那么就需要模糊查询
            List<Map<String,Object>> list = orderMapper.qryUnPayOrderByCarLike(orderTb);
            if(list!=null && list.size()>0){
                orderMap=list.get(0);
            }
        }
        if(orderMap!=null){
            OrmUtil<OrderTb> ormUtil = new OrmUtil<>();
            ormUtil.mapToPojo(orderMap,orderTb);
            logger.debug("~~~~~~~~~~~~~"+orderTb);
            return orderTb;
        }
        return null;
    }

    private Long getCityId(Long comid) {
        //根据车场编号查询集团编号 命中分表约束 根据车牌精确查询
        Long groupid = orderMapper.getGroupIdByComId(comid);
        Long cityid=-1L;
        if(groupid!=null&&groupid>0){
            cityid = orderMapper.getCityIdByGroupId(groupid);
        }else{
            cityid= orderMapper.getCityIdByComId(comid);
        }
        return cityid;
    }

    @Override
    /*
    * 查询这个车牌有没有锁定的在场订单  如果有的话 这个车牌不能绑定
    *
    * */
    public int qryLockedUnPayOrder(String carNumber) {

        int count = orderMapper.qryLockedUnPayOrder(carNumber);
        logger.debug("~~~~~~~"+count);
        return count;
    }

    @Override
    /*
    * 绑定车牌后 更新这个车牌的uin 用作公众号查询
    *
    * */
    public int updateOrderToUin(Long uin, String carNumber) {
        int count = orderMapper.updateOrderToUin(uin,carNumber);
        return count;
    }

    @Override
    /*
    * 进场或者上传订单的时候查询 order_id_local 是不是唯一
    * */
    public int qryCountByOrderId(OrderTb orderTb) {
//        Long cityid = getCityId(comid);
//        OrderTb orderTb = new OrderTb();
//        orderTb.setOrderIdLocal(orderid);
//        orderTb.setComid(comid);
//        orderTb.setCityid(cityid);
        int count = orderMapper.qryCountByOrderId(orderTb);
        logger.info("query orderid is only"+count);
        return count;
    }

    @Override
    /*
    * 进场时 零元结算这个车场的这个车牌
    *
    * */
    public int updateOrderZero(OrderTb orderTb) {
        Map<String,Object> map =orderMapper.qryUnPayOrderByCar(orderTb);
        if(map!=null){
            //这个车有在场订单
            return orderMapper.updateOrderZero(orderTb);
        }
        return 1;
    }

    @Override
    public int qryCountByCarAndOrderId(Long comid, String carNumber, String orderId, Integer type) {
        Long cityid = getCityId(comid);
        OrderTb orderTb = new OrderTb();
        orderTb.setComid(comid);
//        orderTb.setCityid(cityid);
        if(cityid>-1){
            orderTb.setTableName("order_tb_new_"+cityid%100);
        }else{
            orderTb.setTableName("order_tb_new");
        }
        orderTb.setOrder_id_local(orderId);
        orderTb.setCar_number(carNumber);
        if(type==0){//查询在场订单
            return orderMapper.qryInCountByCarAndOrderId(orderTb);
        }else if(type==1){//查询所有订单
            return orderMapper.qryAllCountByCarAndOrderId(orderTb);
        }
        return -1;
    }

    @Override
    /*
    * type  0:查询锁定的在场订单
    *       1：查询所有的在场订单
    * */
    public List<OrderTb> qryOrderListByCarNumber(String carNumber,int type) {


        List<Map<String,Object>> orderTbList= null;
        if(type==0){
            orderTbList=orderMapper.qryOrderListByCarNumber(carNumber);
        }else if(type==1){
            orderTbList=orderMapper.qryAllOrderListByCarNumber(carNumber);
        }

        List<OrderTb> orderTbs =null;
        if(orderTbList!=null&&orderTbList.size()>0){
            OrmUtil<OrderTb> ormUtil = new OrmUtil<>();
            orderTbs=ormUtil.getPojoList(orderTbList,OrderTb.class);
        }
        logger.debug("query order by carnumber:"+orderTbs);
        return orderTbs;
    }

    @Override
    public OrderTb qryOrderById(Long id,String tableName) {
        Map<String,Object> orderMap = orderMapper.qryOrderById(id,tableName);
        if(orderMap!=null){
            OrderTb orderTb = new OrderTb();
            OrmUtil<OrderTb> ormUtil = new OrmUtil<>();
            ormUtil.mapToPojo(orderMap,orderTb);
            return orderTb;
        }
        return null;
    }


    @Override
    public int updateLockStatus(Long id, Integer status,String tableName) {
        return orderMapper.updateLockStatus(id,status,tableName);
    }

    @Override
    public int updateLockStatusAndKey(Long id, Integer status, String lockKey,String tableName) {
        return orderMapper.updateLockStatusAndKey(id,status,lockKey,tableName);
    }

    @Override
    public int insertOrder(OrderTb orderTb) {
        try{
            return orderMapper.insertOrder(orderTb);
        }catch (Exception e){
            logger.error("insert order error:",e);
            return -1;
        }
    }

    @Override
    public OrderTb qryOrderWhenOutPark(OrderTb con) {
        Map<String,Object> orderMap = orderMapper.qryOrderWhenOutPark(con);
        if(orderMap!=null){
            OrderTb orderTb = new OrderTb();
            OrmUtil<OrderTb> ormUtil = new OrmUtil<>();
            ormUtil.mapToPojo(orderMap,orderTb);
            return orderTb;
        }
        return null;
    }

    @Override
    public Integer qryCountWhenOutPark(OrderTb con) {
        return orderMapper.qryCountWhenOutPark(con);
    }

    @Override
    public List<Map<String, Object>> qryOrdersNotByCreateTime(OrderTb newCon) {
        return orderMapper.qryOrdersNotByCreateTime(newCon);
    }

    @Override
    public int updateOrderById(OrderTb orderTb) {
        if(orderTb.getId()==null){
            return -1;
        }
        return orderMapper.updateOrderById(orderTb);
    }

    @Override
    public void updateOrderByOrderIdAndCar(OrderTb orderTb) {
        orderMapper.updateOrderByOrderIdAndCar(orderTb);
    }

    @Override
    public List<Map<String, Object>> qryOrdersByComidAndOrderId(Long parkId, String orderId) {
        //Long groupid = orderMapper.getGroupIdByComId(parkId);
        Long cityId = getCityId(parkId);
        String tableName = "";
        if(cityId>-1){
            tableName = "order_tb_new_"+cityId%100;
        }else{
            tableName = "order_tb_new";
        }
        return orderMapper.qryOrdersByComidAndOrderId(parkId,orderId,tableName);
    }

    @Override
    public void deleteOrderByid(Long id,Long cityid) {
        String tableName = "";
        if(cityid>-1){
            tableName = "order_tb_new_"+cityid%100;
        }else{
            tableName = "order_tb_new";
        }
        orderMapper.deleteOrderByid(id,tableName);
    }

    @Override
    public void deleteOrderByOrderIdAndCar(OrderTb orderTb) {
        orderMapper.deleteOrderByOrderIdAndCar(orderTb);
    }

    @Override
    public Long getCityidByComId(Long comid) {
        return getCityId(comid);
    }

    @Override
    public void updateLockStatusByOrderIdLocal(String orderId, Integer optState, String tableName) {
        orderMapper.updateLockStatusByOrderIdLocal(orderId,optState,tableName);
    }

    @Override
    public OrderTb qryUnPayOrderByNoLicence(String carNumber, Long comid) {
            Long cityid = getCityId(comid);
            OrderTb orderTb = new OrderTb();
            orderTb.setCar_number(carNumber);
            orderTb.setComid(comid);
            if(cityid>-1){
                orderTb.setTableName("order_tb_new_"+cityid%100);
            }else{
                orderTb.setTableName("order_tb_new");
            }
            List<Map<String,Object>> list = orderMapper.qryUnPayOrderByNoLicence(orderTb);
            if(list!=null&&list.size()>0){
                Map<String,Object> orderMap = list.get(0);
                OrmUtil<OrderTb> ormUtil = new OrmUtil<>();
                ormUtil.mapToPojo(orderMap,orderTb);
                return orderTb;
            }
            return null;
    }

    @Override
    public List<OrderTb> getOrderList(int num) {
        List<OrderTb> orderTbList = new ArrayList<>();
        //每次查100条
        Long createTime= System.currentTimeMillis()/1000-400;
        orderTbList = orderMapper.getOrderList("order_tb_new_41",100,num,createTime);
        return orderTbList;
    }
}
