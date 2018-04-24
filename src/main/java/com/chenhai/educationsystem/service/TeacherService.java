package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.domain.TeacherClassHour;
import com.chenhai.educationsystem.domain.TotalClassHour;
import com.chenhai.educationsystem.dto.TeacherIdDto;
import com.chenhai.educationsystem.dto.TotalClassHourIntervalDto;
import com.chenhai.educationsystem.dto.TotalClassHourTypeDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.TeacherClassHourRepository;
import com.chenhai.educationsystem.repository.TeacherRepository;
import com.chenhai.educationsystem.repository.TotalClassHourRepository;
import com.chenhai.educationsystem.vo.TeacherClassHourResult;
import com.chenhai.educationsystem.vo.TeacherResult;
import com.chenhai.educationsystem.vo.TotalClassHourResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherClassHourRepository teacherClassHourRepository;
    @Autowired
    private TotalClassHourRepository totalClassHourRepository;

    public TeacherResult list() throws GlobalException {
        try {
            List<Teacher> teacherList = teacherRepository.findAll();
            return new TeacherResult(teacherList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }


    public TeacherClassHourResult classHour(TeacherIdDto teacherIdDto) throws GlobalException {
        try {
            List<TeacherClassHour> teacherClassHourList = teacherClassHourRepository.findByTeacherId(teacherIdDto.getTeacherId());
            return new TeacherClassHourResult(teacherClassHourList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public TotalClassHourResult totalClassHourByType(TotalClassHourTypeDto totalClassHourTypeDto) throws GlobalException {
        try {
            TotalClassHour totalClassHour=totalClassHourRepository.findByTeacherIdAndType(totalClassHourTypeDto.getTeacherId(), totalClassHourTypeDto.getType());
            if (totalClassHour == null){
                return new TotalClassHourResult(0L);
            }
            return new TotalClassHourResult(totalClassHour.getTotal());
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public TotalClassHourResult totalClassHourByInterval(TotalClassHourIntervalDto totalClassHourIntervalDto) throws GlobalException {
        try {
            TotalClassHour totalClassHour =
                    totalClassHourRepository.findByTeacherIdAndTimeInterval(totalClassHourIntervalDto.getTeacherId(),
                    totalClassHourIntervalDto.getStartTime(),totalClassHourIntervalDto.getEndTime());
            return new TotalClassHourResult(totalClassHour.getTotal());
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
