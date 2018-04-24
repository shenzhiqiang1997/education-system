package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.dto.FeeDto;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.FeeRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.vo.FeeResult;
import com.chenhai.educationsystem.vo.StudentResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FeeRepository feeRepository;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public StudentResult list() throws GlobalException{
        try{
            List<Student> studentList = studentRepository.findAll();
            return new StudentResult(studentList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public SuccessResult delete(StudentIdDto studentIdDto) throws GlobalException {
        try {
            studentRepository.deleteById(studentIdDto.getStudentId());
            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public FeeResult fee(FeeDto feeDto) throws GlobalException {
        try {
            Date ST = sdf.parse(feeDto.getStartTime());
            Date ET = sdf.parse(feeDto.getEndTime());
            Long total = feeRepository.findByStudentId(feeDto.getStudentId(),ST,ET).getTotal();
            FeeResult feeResult = new FeeResult();
            feeResult.setTotal(total);
            return feeResult;
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
