package com.chenhai.educationsystem.vo;

import com.chenhai.educationsystem.domain.Teacher;

import java.util.List;

public class TeacherResult {
    private String flag="true";
    private List<Teacher> teachers;

    public TeacherResult(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
