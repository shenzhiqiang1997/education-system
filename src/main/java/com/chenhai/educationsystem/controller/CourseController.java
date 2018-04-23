package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.CourseDto;
import com.chenhai.educationsystem.dto.CourseIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.CourseService;
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
    public SuccessResult delete(@RequestBody CourseIdDto courseIdDto) throws GlobalException {
        return courseService.delete(courseIdDto);
    }
}
