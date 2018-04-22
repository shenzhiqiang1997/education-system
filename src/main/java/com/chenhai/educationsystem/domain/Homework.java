package com.chenhai.educationsystem.domain;

import javax.persistence.*;

@Entity
public class Homework {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Integer id;
    @Column
    private String content;
    @Column
    private String date;
    @Column
    private String pics;

    public Homework(String content, String date, String pics) {
        this.content = content;
        this.date = date;
        this.pics = pics;
    }

    public Homework() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
