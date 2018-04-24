package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.TeacherIdDto;
import com.chenhai.educationsystem.dto.TotalClassHourDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.TeacherService;
import com.chenhai.educationsystem.vo.TeacherClassHourResult;
import com.chenhai.educationsystem.vo.TeacherResult;
import com.chenhai.educationsystem.vo.TotalClassHourResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/classhour")
    public TeacherClassHourResult classHour(@RequestBody TeacherIdDto teacherIdDto) throws GlobalException {
        return teacherService.classHour(teacherIdDto);
    }

    @PostMapping("/totalclasshour")
    public TotalClassHourResult totalClassHour(@RequestBody TotalClassHourDto totalClassHourDto) throws GlobalException {
        return teacherService.totalClassHour(totalClassHourDto);
    }
}
