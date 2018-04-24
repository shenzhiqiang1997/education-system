package com.chenhai.educationsystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "take_course")
public class TakeCourse{
    @EmbeddedId
    private TakeCourseKey takeCourseKey;

    public TakeCourse(TakeCourseKey takeCourseKey){
        this.takeCourseKey =  takeCourseKey;
    }

    public TakeCourse(TakeCourseKey takeCourseKey, Integer remaining) {
        this.takeCourseKey = takeCourseKey;
    }

    public TakeCourse(){}


    public TakeCourseKey getTakeCourseKey() {
        return takeCourseKey;
    }

    public void setTakeCourseKey(TakeCourseKey takeCourseKey) {
        this.takeCourseKey = takeCourseKey;
    }
}
