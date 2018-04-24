package com.chenhai.educationsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer studentId;
    @Column(name = "remaining")
    private Integer remaining;
    @Column(name = "name")
    private String studentName;
    @Column
    @JsonIgnore
    private String mark;

    public Student(Integer studentId, Integer remaining, String studentName) {
        this.studentId = studentId;
        this.remaining = remaining;
        this.studentName = studentName;
    }

    public Student(String studentName, String mark) {
        this.studentName = studentName;
        this.mark = mark;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
