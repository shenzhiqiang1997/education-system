package com.chenhai.educationsystem.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeeDto {
    private Integer studentId;
    private String startTime;
    private String endTime;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
