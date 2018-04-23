package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.RenewRecord;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.RenewRecordRepository;
import com.chenhai.educationsystem.vo.RenewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenewService {
    @Autowired
    private RenewRecordRepository renewRecordRepository;

    public RenewResult list(StudentIdDto studentIdDto) throws GlobalException {
        try {
            List<RenewRecord> renewRecordList = renewRecordRepository.findByStudentId(studentIdDto.getStudentId());
            return new RenewResult(renewRecordList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }

    }
}
