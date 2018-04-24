package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.CourseDto;
import com.chenhai.educationsystem.dto.CourseRelationDto;
import com.chenhai.educationsystem.dto.RecordDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.CourseService;
import com.chenhai.educationsystem.vo.CourseListResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public SuccessResult add(@RequestBody CourseDto courseDto) throws GlobalException {
        return courseService.add(courseDto);
    }

    @PostMapping("/delete")
    public SuccessResult delete(@RequestBody CourseRelationDto courseRelationDto) throws GlobalException {
        return courseService.delete(courseRelationDto);
    }

    @PostMapping("/list")
    public CourseListResult list() throws GlobalException {
        return courseService.list();
    }

    @PostMapping("/confirm")
    public SuccessResult confirm(@RequestBody RecordDto recordDto) throws GlobalException {
        return courseService.confirm(recordDto);
    }
}
