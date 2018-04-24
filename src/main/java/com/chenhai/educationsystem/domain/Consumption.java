package com.chenhai.educationsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Consumption {
    @Id
    @JsonIgnore
    private String id;
    @Column(name = "student_id")
    @JsonIgnore
    private Integer studentId;
    @Column
    private Float period;
    @Column(name = "start_time")
    private String date;
    @Column
    private String type;
    @Column
    private Integer cost;
    @Column
    private Integer remaining;

    public Consumption() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
