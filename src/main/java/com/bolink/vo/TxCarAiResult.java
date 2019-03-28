package com.bolink.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * 腾讯车型识别结果
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TxCarAiResult {
    private Integer errorcode;

    private String errormsg;

    private List<CarTag> tags;

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public List<CarTag> getTags() {
        return tags;
    }

    public void setTags(List<CarTag> tags) {
        this.tags = tags;
    }
}
