package com.chenhai.educationsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer studentId;
    @Column
    private Integer remaining;
    @Column(name = "name")
    private String studentName;
    @Column
    @JsonIgnore
    private String code;

    public Student(Integer studentId, Integer remaining, String studentName) {
        this.studentId = studentId;
        this.remaining = remaining;
        this.studentName = studentName;
    }

    public Student(String studentName, String code) {
        this.studentName = studentName;
        this.code = code;
    }

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
