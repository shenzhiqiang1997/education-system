package com.chenhai.educationsystem.domain;

import javax.persistence.*;

@Entity
public class Homework {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String content;
    @Column
    private String date;
    @Column
    private String pics;
    @Column(name = "studentId")
    private Integer studentId;

    public Homework(String name, String content, String date, String pics,Integer studentId) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.pics = pics;
        this.studentId = studentId;
    }

    public Homework() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
