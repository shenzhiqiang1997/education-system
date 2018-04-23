package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Consuming;
import com.chenhai.educationsystem.dto.StudentIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.ConsumingRepository;
import com.chenhai.educationsystem.vo.Consumption;
import com.chenhai.educationsystem.vo.ConsumptionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConsumingService {
    @Autowired
    private ConsumingRepository consumingRepository;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DecimalFormat df = new DecimalFormat("#.0");

    public ConsumptionResult list(StudentIdDto studentIdDto) throws GlobalException {
        try {
            Integer studentId = studentIdDto.getStudentId();
            List<Consuming> consumingList = consumingRepository.findByStudentId(studentId);
            List<Consumption> consumptionList = new ArrayList<>();
            for (Consuming consuming:
                 consumingList) {
                Date startTime = sdf.parse(consuming.getStartTime());
                Date endTime = sdf.parse(consuming.getEndTime());
                String type = consuming.getType();
                Integer cost = consuming.getCost();
                Integer remaining = consuming.getRemaining();
                String period = df.format((double)(endTime.getTime() - startTime.getTime())/(double)(1000*3600));
                Consumption consumption = new Consumption(consuming.getStartTime(),type,period,cost,remaining);
                consumptionList.add(consumption);
            }
            return new ConsumptionResult(consumptionList);
        } catch (Exception e){
            e.printStackTrace();
            throw new GlobalException(Message.ERROR);
        }
    }
}
