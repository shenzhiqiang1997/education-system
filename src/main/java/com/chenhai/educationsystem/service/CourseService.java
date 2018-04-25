package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.*;
import com.chenhai.educationsystem.dto.CourseDto;
import com.chenhai.educationsystem.dto.CourseRelationDto;
import com.chenhai.educationsystem.dto.RecordDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.*;
import com.chenhai.educationsystem.vo.CourseListResult;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TakeCourseRepository takeCourseRepository;
    @Autowired
    private ClassHourRepository classHourRepository;
    @Autowired
    private CourseListRepository courseListRepository;
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseReferenceRepository courseReferenceRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    @Transactional(rollbackFor = Exception.class)
    public SuccessResult add(CourseDto courseDto) throws GlobalException {
        try{
            List<Integer> studentIds = courseDto.getStudentIds();

            Course course = new Course(courseDto.getCourseName(),courseDto.getTeacherId(),
                    courseDto.getStartTime(),courseDto.getEndTime(),courseDto.getMark(),
                    courseDto.getCost(),String.valueOf(studentIds.size()));

            course = courseRepository.saveAndFlush(course);
            Integer courseId = course.getId();

            long startTime = sdf.parse(course.getStartTime()).getTime();
            long endTime = sdf.parse(course.getEndTime()).getTime();
            Float duration = ((float)(endTime - startTime)/(float)(1000*3600));
            ClassHour classHour = new ClassHour(courseId,duration);
            classHourRepository.save(classHour);

            for (Integer studentId:
                 studentIds)
                takeCourseRepository.save(new TakeCourse(new TakeCourseKey(courseId,studentId)));


            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public SuccessResult delete(CourseRelationDto courseRelationDto) throws GlobalException {
        try {
            takeCourseRepository.deleteById(new TakeCourseKey(courseRelationDto.getClassId(),courseRelationDto.getStudentId()));

            long referenceCount = courseReferenceRepository.countByCourseId(courseRelationDto.getClassId());
            if (referenceCount == 0)
                courseRepository.deleteById(courseRelationDto.getClassId());

            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public CourseListResult list() throws GlobalException {
        try {
            List<CourseList> courseListList = courseListRepository.findAll();
            return new CourseListResult(courseListList);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public SuccessResult confirm(RecordDto recordDto) throws GlobalException {
        try {
            Integer studentId = recordDto.getStudentId();
            Student student = studentRepository.findByStudentId(studentId);
            Integer remaining = student.getRemaining();
            Integer fee = recordDto.getFee();
            Integer newRemaining = remaining - fee;
            student.setRemaining(newRemaining);
            studentRepository.save(student);

            Record record = new Record(recordDto.getStudentId(),recordDto.getCourseId(),recordDto.getTeacherId(),recordDto.getStudent(),
                    recordDto.getCourseName(),recordDto.getTeacherName(),recordDto.getStartTime(),recordDto.getEndTime(),recordDto.getType(),
                    recordDto.getFee(),newRemaining,recordDto.getPeriod(),recordDto.getMark());
            recordRepository.save(record);

            takeCourseRepository.deleteById(new TakeCourseKey(recordDto.getCourseId(),recordDto.getStudentId()));

            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
