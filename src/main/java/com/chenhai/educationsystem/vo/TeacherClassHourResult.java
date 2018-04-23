package com.chenhai.educationsystem.vo;

import com.chenhai.educationsystem.domain.TeacherClassHour;

import java.util.List;

public class TeacherClassHourResult {
    private String flag = "true";
    private List<TeacherClassHour> classhour;

    public TeacherClassHourResult(List<TeacherClassHour> classhour) {
        this.classhour = classhour;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<TeacherClassHour> getClasshour() {
        return classhour;
    }

    public void setClasshour(List<TeacherClassHour> classhour) {
        this.classhour = classhour;
    }
}

