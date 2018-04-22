package com.chenhai.educationsystem.vo;

import com.chenhai.educationsystem.domain.Student;

import java.util.List;

public class StudentResult {
    private String flag = "true";
    private List<Student> student;

    public StudentResult(List<Student> studentList){
        this.student = studentList;
    }
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
