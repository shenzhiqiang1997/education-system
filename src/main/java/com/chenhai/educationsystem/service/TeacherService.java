package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.TeacherRepository;
import com.chenhai.educationsystem.vo.TeacherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    public TeacherResult list() throws GlobalException {
        try {
            List<Teacher> teacherList = teacherRepository.findAll();
            return new TeacherResult(teacherList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
