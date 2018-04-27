package com.chenhai.educationsystem.domain.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseMessage {
    @Id
    private String id;
    @Column
    private String openid;
    @Column
    private String personName;
    @Column
    private String courseName;
    @Column
    private String time;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CourseMessage{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", personName='" + personName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
