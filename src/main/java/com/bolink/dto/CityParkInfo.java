package com.bolink.dto;

/**
 * Created by waynelu on 2018/6/26.
 */
public class CityParkInfo {
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

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  Integer id;
    private  Integer union_id;
    private String park_id;
    private  Integer city_id;
}
