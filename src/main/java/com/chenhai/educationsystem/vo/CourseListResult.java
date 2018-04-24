package com.chenhai.educationsystem.vo;

import com.chenhai.educationsystem.domain.CourseList;

import java.util.List;

public class CourseListResult {
    private String flag = "true";
    private List<CourseList> classList;

    public CourseListResult(List<CourseList> classList) {
        this.classList = classList;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<CourseList> getClassList() {
        return classList;
    }

    public void setClassList(List<CourseList> classList) {
        this.classList = classList;
    }
}
