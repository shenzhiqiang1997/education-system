package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.ConsumingService;
import com.chenhai.educationsystem.vo.ConsumptionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumingService consumingService;
    @PostMapping("/list")
    public ConsumptionResult list(@RequestBody StudentIdDto studentIdDto) throws GlobalException {
        return consumingService.list(studentIdDto);
    }
}
