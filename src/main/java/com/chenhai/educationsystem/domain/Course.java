package com.chenhai.educationsystem.domain;

import javax.persistence.*;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer teacherId;
    @Column
    private String startTime;
    @Column
    private String endTime;
    @Column
    private String description;
    @Column
    private Integer cost;
    @Column
    private String type;

    public Course(String name, Integer teacherId, String startTime, String endTime, String description, Integer cost, String type) {
        this.name = name;
        this.teacherId = teacherId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.cost = cost;
        this.type = type;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
