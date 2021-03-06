package com.chenhai.educationsystem.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework_feedback")
public class HomeworkFeedback {
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "wechatId")
    private String wechatId;
    @Column
    private String content;
    @Column
    private String pics;
    @Column(name = "uploadTime")
    private Date uploadTime=new Date();
    @Column
    private String name;

    public HomeworkFeedback(String wechatId, String content, String pics,String name) {
        this.wechatId = wechatId;
        this.content = content;
        this.pics = pics;
        this.name = name;
    }

    public HomeworkFeedback(String wechatId, String content, String name) {
        this.wechatId = wechatId;
        this.content = content;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
