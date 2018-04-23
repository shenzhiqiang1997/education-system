package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.TeacherService;
import com.chenhai.educationsystem.vo.TeacherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/list")
    public TeacherResult list() throws GlobalException {
        return teacherService.list();
    }
}