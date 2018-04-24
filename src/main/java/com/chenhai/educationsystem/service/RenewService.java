package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.RenewRecord;
import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.dto.RenewDto;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.RenewRecordRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.vo.RenewResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RenewService {
    @Autowired
    private RenewRecordRepository renewRecordRepository;
    @Autowired
    private StudentRepository studentRepository;
    public RenewResult list(StudentIdDto studentIdDto) throws GlobalException {
        try {
            List<RenewRecord> renewRecordList = renewRecordRepository.findByStudentId(studentIdDto.getStudentId());
            return new RenewResult(renewRecordList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }

    }

    @Transactional
    public SuccessResult recharge(RenewDto renewDto) throws GlobalException {
        try {
            Student student = studentRepository.findByStudentId(renewDto.getStudentId());
            Integer newRemaining = student.getRemaining() + renewDto.getCharge();
            student.setRemaining(newRemaining);
            studentRepository.save(student);

            RenewRecord renewRecord = new RenewRecord(new Date(),renewDto.getCharge(),newRemaining,renewDto.getStudentId());
            renewRecordRepository.save(renewRecord);
            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
