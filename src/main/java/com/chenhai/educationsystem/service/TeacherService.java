package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.domain.TeacherClassHour;
import com.chenhai.educationsystem.domain.TotalClassHour;
import com.chenhai.educationsystem.dto.TeacherIdDto;
import com.chenhai.educationsystem.dto.TotalClassHourDto;
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
            List<TeacherClassHour> teacherClassHourList = teacherClassHourRepository.findAllByTeacherId(teacherIdDto.getTeacherId());
            return new TeacherClassHourResult(teacherClassHourList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public TotalClassHourResult totalClassHour(TotalClassHourDto totalClassHourDto) throws GlobalException {
        try {
            TotalClassHour totalClassHour=totalClassHourRepository.findByTeacherIdAndType(totalClassHourDto.getTeacherId(),totalClassHourDto.getType());
            return new TotalClassHourResult(totalClassHour.getTotal());
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
