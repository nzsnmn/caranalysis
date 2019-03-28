package com.bolink.dto;

import java.math.BigDecimal;

public class OrderTb {
    private Long id;

    private Long create_time;

    private Long comid;

    private Long uin;

    private BigDecimal total;

    private Integer state;

    private Long end_time;

    private Integer auto_pay;

    private Integer pay_type;

    private String nfc_uuid;

    private Long uid;

    private String car_number;

    private String imei;

    private Integer pid;

    private Integer pre_state;

    private Integer type;

    private Integer need_sync;

    private Integer ishd;

    private Integer isclick;

    private BigDecimal prepaid;

    private Long prepaid_payTime;

    private Long berthnumber;

    private Long berthsec_id;

    private Long groupid;

    private String order_id_local;

    private Long duration;

    private Long cityid;

    private String tableName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getComid() {
        return comid;
    }

    public void setComid(Long comid) {
        this.comid = comid;
    }

    public Long getUin() {
        return uin;
    }

    public void setUin(Long uin) {
        this.uin = uin;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public Integer getAuto_pay() {
        return auto_pay;
    }

    public void setAuto_pay(Integer auto_pay) {
        this.auto_pay = auto_pay;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public String getNfc_uuid() {
        return nfc_uuid;
    }

    public void setNfc_uuid(String nfc_uuid) {
        this.nfc_uuid = nfc_uuid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPre_state() {
        return pre_state;
    }

    public void setPre_state(Integer pre_state) {
        this.pre_state = pre_state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNeed_sync() {
        return need_sync;
    }

    public void setNeed_sync(Integer need_sync) {
        this.need_sync = need_sync;
    }

    public Integer getIshd() {
        return ishd;
    }

    public void setIshd(Integer ishd) {
        this.ishd = ishd;
    }

    public Integer getIsclick() {
        return isclick;
    }

    public void setIsclick(Integer isclick) {
        this.isclick = isclick;
    }

    public BigDecimal getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(BigDecimal prepaid) {
        this.prepaid = prepaid;
    }

    public Long getPrepaid_payTime() {
        return prepaid_payTime;
    }

    public void setPrepaid_payTime(Long prepaid_payTime) {
        this.prepaid_payTime = prepaid_payTime;
    }

    public Long getBerthnumber() {
        return berthnumber;
    }

    public void setBerthnumber(Long berthnumber) {
        this.berthnumber = berthnumber;
    }

    public Long getBerthsec_id() {
        return berthsec_id;
    }

    public void setBerthsec_id(Long berthsec_id) {
        this.berthsec_id = berthsec_id;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getOrder_id_local() {
        return order_id_local;
    }

    public void setOrder_id_local(String order_id_local) {
        this.order_id_local = order_id_local;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}