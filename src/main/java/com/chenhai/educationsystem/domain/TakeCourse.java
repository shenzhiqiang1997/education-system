package com.chenhai.educationsystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "take_course")
public class TakeCourse{
    @EmbeddedId
    private TakeCourseKey takeCourseKey;
    @Column
    private Integer remaining;

    public TakeCourse(TakeCourseKey takeCourseKey){
        this.takeCourseKey =  takeCourseKey;
    }

    public TakeCourse(TakeCourseKey takeCourseKey, Integer remaining) {
        this.takeCourseKey = takeCourseKey;
        this.remaining = remaining;
    }

    public TakeCourse(){}

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public TakeCourseKey getTakeCourseKey() {
        return takeCourseKey;
    }

    public void setTakeCourseKey(TakeCourseKey takeCourseKey) {
        this.takeCourseKey = takeCourseKey;
    }
}
