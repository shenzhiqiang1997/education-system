package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.FeedbackService;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/add")
    public SuccessResult add(@RequestParam("studentId") String studentId,
                             @RequestParam("courseName") String name,
                             @RequestParam("feedback") String feedback,
                             @RequestParam(value = "pic",required = false)MultipartFile multipartFile,
                             @RequestParam("type") String type) throws GlobalException {
        return feedbackService.add(studentId,name,feedback,multipartFile,type);
    }
}
