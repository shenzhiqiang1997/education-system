package com.chenhai.educationsystem.vo;

import java.util.List;

public class ConsumptionResult {
    private String flag = "true";
    private List<Consumption> consumption;

    public ConsumptionResult() {
    }

    public ConsumptionResult(List<Consumption> consumption) {
        this.consumption = consumption;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Consumption> getConsumption() {
        return consumption;
    }

    public void setConsumption(List<Consumption> consumption) {
        this.consumption = consumption;
    }
}
