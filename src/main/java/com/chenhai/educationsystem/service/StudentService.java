package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.vo.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentResult list() throws GlobalException{
        try{
            List<Student> studentList = studentRepository.findAll();
            return new StudentResult(studentList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
