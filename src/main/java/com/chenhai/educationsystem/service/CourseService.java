package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.*;
import com.chenhai.educationsystem.dto.CourseDto;
import com.chenhai.educationsystem.dto.CourseIdDto;
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
    private StudentRepository studentRepository;
    @Autowired
    private ClassHourRepository classHourRepository;
    @Autowired
    private CourseListRepository courseListRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh HH:mm:ss");

    @Transactional
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
                 studentIds) {
                Student student = studentRepository.findById(studentId).get();
                student.setRemaining(student.getRemaining()-course.getCost());
                studentRepository.save(student);

                takeCourseRepository.save(new TakeCourse(new TakeCourseKey(courseId,studentId),student.getRemaining()));
            }
            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    @Transactional
    public SuccessResult delete(CourseIdDto courseIdDto) throws GlobalException {
        try {
            courseRepository.deleteById(courseIdDto.getCourseId());
            return new SuccessResult();
        } catch (Exception e){
            e.printStackTrace();
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
}
