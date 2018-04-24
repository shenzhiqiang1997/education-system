package com.chenhai.educationsystem.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TotalClassHourIntervalDto {
    private Integer teacherId;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date endTime;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
