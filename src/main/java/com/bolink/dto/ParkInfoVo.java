package com.bolink.dto;

public class ParkInfoVo {
    private Long union_id;
    private String park_id;
    private String park_name;
    private String union_name;
    private String local_id;
    private Long lastbeat_time;
    private String lastbeat_date;
    private String version;
    private boolean disableUpd;

    public String getLastbeat_date() {
        return lastbeat_date;
    }

    public void setLastbeat_date(String lastbeat_date) {
        this.lastbeat_date = lastbeat_date;
    }

    public Long getUnion_id() {
        return union_id;
    }

    public void setUnion_id(Long union_id) {
        this.union_id = union_id;
    }

    public String getPark_id() {
        return park_id;
    }

    public void setPark_id(String park_id) {
        this.park_id = park_id;
    }

    public String getPark_name() {
        return park_name;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public String getUnion_name() {
        return union_name;
    }

    public void setUnion_name(String union_name) {
        this.union_name = union_name;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public Long getLastbeat_time() {
        return lastbeat_time;
    }

    public void setLastbeat_time(Long lastbeat_time) {
        this.lastbeat_time = lastbeat_time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isDisableUpd() {
        return disableUpd;
    }

    public void setDisableUpd(boolean disableUpd) {
        this.disableUpd = disableUpd;
    }
}
