package com.bolink.dto;

import java.math.BigDecimal;

public class UnionOrderUnpayNtb {
    private Long id;

    private String plateNumber;

    private Long startTime;

    private Long recordTime;

    private Long unionId;

    private BigDecimal total;

    private String orderId;

    private String parkId;

    private String localId;

    private Integer duration;

    private Integer freeOutTime;

    private Long queryTime;

    private Long queryPriceTime;

    private BigDecimal derateMoney;

    private Integer derateDuration;

    private BigDecimal price;

    private String queryOrderNo;

    private Integer state;

    private String outChannelId;

    private String errmsg;

    private String stopPosition;

    private String tradeNo;

    private Integer hideInparkInfo;

    private String picUrl;

    private String subNumber;

    private BigDecimal prepayMoney;

    private Integer multiplePrepay;

    private BigDecimal deduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Long recordTime) {
        this.recordTime = recordTime;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId == null ? null : localId.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getFreeOutTime() {
        return freeOutTime;
    }

    public void setFreeOutTime(Integer freeOutTime) {
        this.freeOutTime = freeOutTime;
    }

    public Long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Long queryTime) {
        this.queryTime = queryTime;
    }

    public Long getQueryPriceTime() {
        return queryPriceTime;
    }

    public void setQueryPriceTime(Long queryPriceTime) {
        this.queryPriceTime = queryPriceTime;
    }

    public BigDecimal getDerateMoney() {
        return derateMoney;
    }

    public void setDerateMoney(BigDecimal derateMoney) {
        this.derateMoney = derateMoney;
    }

    public Integer getDerateDuration() {
        return derateDuration;
    }

    public void setDerateDuration(Integer derateDuration) {
        this.derateDuration = derateDuration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getQueryOrderNo() {
        return queryOrderNo;
    }

    public void setQueryOrderNo(String queryOrderNo) {
        this.queryOrderNo = queryOrderNo == null ? null : queryOrderNo.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOutChannelId() {
        return outChannelId;
    }

    public void setOutChannelId(String outChannelId) {
        this.outChannelId = outChannelId == null ? null : outChannelId.trim();
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg == null ? null : errmsg.trim();
    }

    public String getStopPosition() {
        return stopPosition;
    }

    public void setStopPosition(String stopPosition) {
        this.stopPosition = stopPosition == null ? null : stopPosition.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getHideInparkInfo() {
        return hideInparkInfo;
    }

    public void setHideInparkInfo(Integer hideInparkInfo) {
        this.hideInparkInfo = hideInparkInfo;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(String subNumber) {
        this.subNumber = subNumber == null ? null : subNumber.trim();
    }

    public BigDecimal getPrepayMoney() {
        return prepayMoney;
    }

    public void setPrepayMoney(BigDecimal prepayMoney) {
        this.prepayMoney = prepayMoney;
    }

    public Integer getMultiplePrepay() {
        return multiplePrepay;
    }

    public void setMultiplePrepay(Integer multiplePrepay) {
        this.multiplePrepay = multiplePrepay;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }
}