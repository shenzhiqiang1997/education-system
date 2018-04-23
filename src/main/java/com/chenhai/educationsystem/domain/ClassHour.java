package com.chenhai.educationsystem.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClassHour {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "courseId")
    private Integer courseId;
    @Column(name = "uploadTime")
    private Date uploadTime = new Date();
    @Column
    private Float duration;

    public ClassHour(Integer courseId, Float duration) {
        this.courseId = courseId;
        this.duration = duration;
    }

    public ClassHour() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

}
