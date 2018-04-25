package com.chenhai.educationsystem.vo;

public class TotalClassHourResult {
    private String flag = "true";
    private Float total;

    public TotalClassHourResult(Float total) {
        this.total = total;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
