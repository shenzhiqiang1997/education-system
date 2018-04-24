package com.chenhai.educationsystem.exception.handler;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.vo.FailureResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public FailureResult jsonErrorHandler(HttpServletRequest request,Exception e){
        e.printStackTrace();
        if (e instanceof GlobalException)
            return  new FailureResult(e.getMessage());
        else
            return new FailureResult(Message.ERROR);
    }
}
