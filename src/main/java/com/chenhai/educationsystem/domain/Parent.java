package com.chenhai.educationsystem.domain;

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
    private String code;

    public Parent(String name, Integer studentId, String code) {
        this.name = name;
        this.studentId = studentId;
        this.code = code;
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

    public void setCode(String code) {
        this.code = code;
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

    public String getCode() {
        return code;
    }
}
