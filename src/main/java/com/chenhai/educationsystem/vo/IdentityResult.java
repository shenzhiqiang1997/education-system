package com.chenhai.educationsystem.vo;

public class IdentityResult {
    private String flag = "true";
    private String identity;

    public IdentityResult(String identity) {
        this.identity = identity;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
