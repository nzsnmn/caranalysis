package com.bolink.dto;

/**
 * 地区表
 * Created by waynelu on 2018/6/26.
 */
public class AreaTb {
    private  Integer id;
    private  Integer  area_code ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea_code() {
        return area_code;
    }

    public void setArea_code(Integer area_code) {
        this.area_code = area_code;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    private  String area_name;
}
