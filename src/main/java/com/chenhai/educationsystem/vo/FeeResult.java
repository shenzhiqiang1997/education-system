package com.chenhai.educationsystem.vo;

public class FeeResult {
    private String flag = "true";
    private Long total;

    public FeeResult(Long total) {
        this.total = total;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
