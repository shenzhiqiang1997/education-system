package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.RenewDto;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.RenewService;
import com.chenhai.educationsystem.vo.RenewResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/renew")
public class RenewController {
    @Autowired
    private RenewService renewService;

    @PostMapping("/list")
    public RenewResult list(@RequestBody StudentIdDto studentIdDto) throws GlobalException {
        return renewService.list(studentIdDto);
    }

    @PostMapping("/recharge")
    public SuccessResult recharge(@RequestBody RenewDto renewDto) throws GlobalException {
        return renewService.recharge(renewDto);
    }


}
