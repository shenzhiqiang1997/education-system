package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Consumption;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.ConsumptionRepository;
import com.chenhai.educationsystem.vo.ConsumptionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;

    public ConsumptionResult list(StudentIdDto studentIdDto) throws GlobalException {
        try {
            Integer studentId = studentIdDto.getStudentId();
            List<Consumption> consumptionList = consumptionRepository.findByStudentId(studentId);
            return new ConsumptionResult(consumptionList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
