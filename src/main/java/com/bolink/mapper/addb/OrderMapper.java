package com.bolink.mapper.addb;

import com.bolink.dto.OrderTb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface OrderMapper {
    //优惠券根据车牌查询这个车场下面的在场订单
    Map<String,Object> qryUnPayOrderByCar(OrderTb orderTb);

    //使用优惠券的时候车牌省份识别错误  需要去掉第一个字模糊查询在场订单
    List<Map<String,Object>> qryUnPayOrderByCarLike(OrderTb orderTb);

    //公众号绑定车牌查询这个车牌有没有 锁定的在场订单 state 0;islock 1 ;ishd 0
    int qryLockedUnPayOrder(String carNumber);

    //公众号绑定车牌时 更新在场订单 所属user
    int updateOrderToUin(@Param("uin") Long uin, @Param("carNumber") String carNumber);

    //进场或者上传订单时查询上传的订单号在这个车场是不是唯一
    int qryCountByOrderId(OrderTb orderTb);

    //进场时零元结算这个车场 的这个车牌的在场订单
    int updateOrderZero(OrderTb orderTb);

    //出场时查询这辆车 的在场或者已结算订单  type 0 ,查询在场订单； 1，查询所有订单
    int qryInCountByCarAndOrderId(OrderTb orderTb);

    //出场时查询这辆车 查询所有订单
    int qryAllCountByCarAndOrderId(OrderTb orderTb);

    //根据车牌查询所有的   锁定的 在场订单
//    @Select("select * from order_tb where car_number=#{carNumber}")
    List<Map<String,Object>> qryOrderListByCarNumber(String carNumber);

    //根据订单Id获取订单
//    @Select("SELECT * FROM order_tb WHERE id = #{id} ")
    Map<String,Object> qryOrderById(@Param("id") Long id, @Param("tableName") String tableName);

    //锁车根据订单id更新订单的锁车状态
    int updateLockStatus(@Param("id") Long id, @Param("islocked") Integer status, @Param("tableName") String tableName);

    //插入订单
    int insertOrder(OrderTb orderTb);

    //根据comid查询groupid
    @Select("select groupid from com_info_tb where id =#{comid} and state=0")
    Long getGroupIdByComId(Long comid);

    //根据车牌查询所有的  在场订单
    List<Map<String,Object>> qryAllOrderListByCarNumber(String carNumber);

    //锁车根据订单id更新订单的锁车状态 和 锁车lockKey
    int updateLockStatusAndKey(@Param("id") Long id, @Param("islocked") Integer status, @Param("lockKey") String lockKey, @Param("tableName") String tableName);


    Map<String,Object> qryOrderWhenOutPark(OrderTb con);

    Integer qryCountWhenOutPark(OrderTb con);

    List<Map<String,Object>> qryOrdersNotByCreateTime(OrderTb newCon);

    int updateOrderById(OrderTb orderTb);

    void updateOrderByOrderIdAndCar(OrderTb orderTb);

    List<Map<String,Object>> qryOrdersByComidAndOrderId(@Param("comid") Long parkId, @Param("orderIdLocal") String orderId, @Param("tableName") String tableName);

    @Select("select cityid from com_info_tb where id =#{comid} and state=0")
    Long getCityIdByComId(Long comid);

    @Select("select cityid from org_group_tb where id =#{groupid} and state=0")
    Long getCityIdByGroupId(Long groupid);

    @Delete("delete from ${tableName} where id = #{id} ")
    void deleteOrderByid(@Param("id") Long id, @Param("tableName") String tableName);

    void deleteOrderByOrderIdAndCar(OrderTb orderTb);

    void updateLockStatusByOrderIdLocal(@Param("orderIdLocal") String orderId, @Param("state") Integer optState, @Param("tableName") String tableName);

    List<Map<String,Object>>  qryUnPayOrderByNoLicence(OrderTb orderTb);


    @Select("select * from org_group_tb where state=0 limit #{pageSize} offset #{pageNumber}")
    List<Map<String,Object>> getGroupList(@Param("pageSize") Integer pageSize,@Param("pageNumber")Integer pageNumber);

    @Select("select t1.* from ${tableName} t1 where t1.create_time > #{create_time} order by  t1.create_time desc limit #{pageSize} offset #{pageNumber}")
    List<OrderTb> getOrderList(@Param("tableName") String tableName,@Param("pageSize") Integer pageSize,@Param("pageNumber")Integer pageNumber,@Param("create_time")Long createTime);
}
