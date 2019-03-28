package com.bolink.dto;

/**
 * Created by waynelu on 2018/6/26.
 */
public class AccountPlatformRelationTb {
    private  Integer platform_id;

    public Integer getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(Integer platform_id) {
        this.platform_id = platform_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    private  Integer account_id;
}
