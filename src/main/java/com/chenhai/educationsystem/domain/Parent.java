package com.chenhai.educationsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Parent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column
    private String name;
    @Column(name = "studentId")
    private Integer studentId;
    @Column
    private String mark;
    @Column
    @JsonIgnore
    private String wechatId;

    public Parent(String name, Integer studentId, String mark) {
        this.name = name;
        this.studentId = studentId;
        this.mark = mark;
    }

    public Parent() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getMark() {
        return mark;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", mark='" + mark + '\'' +
                ", wechatId='" + wechatId + '\'' +
                '}';
    }
}
