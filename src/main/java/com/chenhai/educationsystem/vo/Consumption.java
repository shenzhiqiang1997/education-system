package com.chenhai.educationsystem.vo;

public class Consumption {
    private String date;
    private String type;
    private String period;
    private Integer cost;
    private Integer remaining;

    public Consumption() {
    }

    public Consumption(String date, String type, String period, Integer cost, Integer remaining) {
        this.date = date;
        this.type = type;
        this.period = period;
        this.cost = cost;
        this.remaining = remaining;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
