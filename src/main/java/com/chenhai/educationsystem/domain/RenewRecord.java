package com.chenhai.educationsystem.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_classhour_renew")
public class RenewRecord {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "uploadTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Column
    private Integer figure;
    @Column
    private Integer remain;
    @Column
    @JsonIgnore
    private Integer studentId;

    public RenewRecord() {
    }

    public RenewRecord(Date date, Integer figure, Integer remain) {
        this.date = date;
        this.figure = figure;
        this.remain = remain;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getFigure() {
        return figure;
    }

    public void setFigure(Integer figure) {
        this.figure = figure;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }
}
