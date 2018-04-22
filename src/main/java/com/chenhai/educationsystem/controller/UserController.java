package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.domain.User;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.UserService;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public SuccessResult login(@RequestBody User user) throws GlobalException {
        return userService.login(user);
    }
}
