package com.chenhai.educationsystem.controller;

import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.service.HomeworkService;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/homework")
public class HomeworkController {
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/add")
    public SuccessResult add(@RequestParam("pics")MultipartFile multipartFile, @RequestParam("name")String name,
                             @RequestParam("content")String content,
                             @RequestParam("date")String date,
                             @RequestParam("studentIds")String studentIds) throws GlobalException {
        return homeworkService.add(multipartFile,name,content,date,studentIds);
    }
}
