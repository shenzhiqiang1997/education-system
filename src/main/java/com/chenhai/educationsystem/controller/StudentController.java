package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.FeeDto;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.StudentService;
import com.chenhai.educationsystem.vo.FeeResult;
import com.chenhai.educationsystem.vo.StudentResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/list")
    public StudentResult list() throws GlobalException {
        return studentService.list();
    }

    @PostMapping("/delete")
    public SuccessResult delete(@RequestBody StudentIdDto studentIdDto) throws GlobalException {
        return studentService.delete(studentIdDto);
    }

    @PostMapping("/fee")
    public FeeResult fee(@RequestBody FeeDto feeDto) throws GlobalException {
        System.out.println(feeDto.getEndTime());
        System.out.println(feeDto.getStudentId());
        return studentService.fee(feeDto);
    }
}
