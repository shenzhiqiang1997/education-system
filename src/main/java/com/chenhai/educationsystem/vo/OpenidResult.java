package com.chenhai.educationsystem.vo;

public class OpenidResult {
    private String flag = "true";
    private String openid;

    public OpenidResult(String openid) {
        this.openid = openid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
