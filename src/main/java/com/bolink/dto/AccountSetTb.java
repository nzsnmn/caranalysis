package com.bolink.dto;

/**
 * Created by waynelu on 2018/6/26.
 */
public class AccountSetTb {
    private  Integer union_id;
    private String park_id;

    public Integer getUnion_id() {
        return union_id;
    }

    public void setUnion_id(Integer union_id) {
        this.union_id = union_id;
    }

    public String getPark_id() {
        return park_id;
    }

    public void setPark_id(String park_id) {
        this.park_id = park_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private  String city;
}
