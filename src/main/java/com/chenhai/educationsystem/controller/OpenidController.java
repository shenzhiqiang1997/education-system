package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.dto.CodeDto;
import com.chenhai.educationsystem.dto.OpenidDto;
import com.chenhai.educationsystem.dto.OpenidIdentityDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.OpenidService;
import com.chenhai.educationsystem.vo.IdentityResult;
import com.chenhai.educationsystem.vo.OpenidResult;
import com.chenhai.educationsystem.vo.SuccessMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openid")
public class OpenidController {
    @Autowired
    private OpenidService openidService;

    @PostMapping("/get")
    public OpenidResult get(@RequestBody CodeDto codeDto) throws GlobalException {
        return openidService.get(codeDto);
    }

    @PostMapping("/identify")
    public IdentityResult identify(@RequestBody OpenidDto openidDto) throws GlobalException {
        return openidService.identify(openidDto);
    }

    @PostMapping("/bind")
    public SuccessMessageResult bind(@RequestBody OpenidIdentityDto openidIdentityDto) throws Exception {
        return openidService.bind(openidIdentityDto);
    }

}
