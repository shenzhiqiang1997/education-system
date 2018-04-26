package com.chenhai.educationsystem.vo;

public class SuccessMessageResult {
    private String flag = "true";
    private String msg ;

    public SuccessMessageResult(String msg) {
        this.msg = msg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
