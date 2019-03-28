package com.bolink.service;


import com.bolink.dto.OrderTb;
import java.util.List;
import java.util.Map;

public interface OrderService {
    //优惠券根据车牌查询这个车场下面的在场订单
    OrderTb qryUnPayOrderByCar(String carNumber, Long comid);

    //公众号绑定车牌查询这个车牌有没有 锁定的在场订单 state 0;islock 1 ;ishd 0
    int qryLockedUnPayOrder(String carNumber);

    //公众号绑定车牌时 更新在场订单 所属user
    int updateOrderToUin(Long uin, String carNumber);

    //进场或者上传订单时查询上传的订单号在这个车场是不是唯一
    int qryCountByOrderId(OrderTb orderTb);

    //进场时零元结算这个车场 的这个车牌的在场订单
    int updateOrderZero(OrderTb orderTb);

    //出场时查询这辆车 的在场或者已结算订单  type 0 ,查询锁定的在场订单； 1，查询所有在场订单
    int qryCountByCarAndOrderId(Long comid, String carNumber, String orderId, Integer type);

    //根据车牌查询所有的的在场订单   int type 0:查询锁定的   1：查询左右的
    List<OrderTb> qryOrderListByCarNumber(String carNumber, int type);

    //根据id查询订单
    OrderTb qryOrderById(Long id, String tableName);

    //锁车根据订单id更新订单的锁车状态
    int updateLockStatus(Long id, Integer status, String tableName);

    //锁车根据订单id更新订单的锁车状态和lockkey
    int updateLockStatusAndKey(Long id, Integer status, String lockKey, String tableName);

    //插入订单
    int insertOrder(OrderTb orderTb);

    //出场时 查询 订单
    OrderTb qryOrderWhenOutPark(OrderTb con);
    // 出场时查询订单数量
    Integer qryCountWhenOutPark(OrderTb con);

    List<Map<String,Object>> qryOrdersNotByCreateTime(OrderTb newCon);

    int updateOrderById(OrderTb orderTb);

    void updateOrderByOrderIdAndCar(OrderTb orderTb);

    List<Map<String,Object>> qryOrdersByComidAndOrderId(Long parkId, String orderId);

    void deleteOrderByid(Long id, Long cityid);

    void deleteOrderByOrderIdAndCar(OrderTb orderTb);

    Long getCityidByComId(Long comid);

    void updateLockStatusByOrderIdLocal(String orderId, Integer optState, String tableName);

    OrderTb qryUnPayOrderByNoLicence(String carNumber, Long comid);

    List<OrderTb> getOrderList(int num);
}
