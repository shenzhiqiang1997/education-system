package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.StudentService;
import com.chenhai.educationsystem.vo.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/get")
    public StudentResult list() throws GlobalException {
        return studentService.list();
    }
}
