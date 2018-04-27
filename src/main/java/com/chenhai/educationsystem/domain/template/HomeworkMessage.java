package com.chenhai.educationsystem.domain.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HomeworkMessage {
    @Id
    private String id;
    @Column
    private String openid;
    @Column
    private String studentName;
    @Column
    private String date;
    @Column
    private String homeworkName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    @Override
    public String toString() {
        return "HomeworkMessage{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", studentName='" + studentName + '\'' +
                ", date='" + date + '\'' +
                ", homeworkName='" + homeworkName + '\'' +
                '}';
    }
}
