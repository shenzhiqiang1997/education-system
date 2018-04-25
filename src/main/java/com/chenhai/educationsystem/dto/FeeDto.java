package com.chenhai.educationsystem.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeeDto {
    private Integer studentId;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date endTime;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
