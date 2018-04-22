package com.chenhai.educationsystem.exception.handler;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.vo.FailureResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public FailureResult jsonErrorHandler(HttpServletRequest request,GlobalException e){
        return  new FailureResult(e.getMessage());
    }
}
