package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.Course;
import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.domain.TakeCourse;
import com.chenhai.educationsystem.domain.TakeCourseKey;
import com.chenhai.educationsystem.dto.CourseDto;
import com.chenhai.educationsystem.dto.CourseIdDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.CourseRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.repository.TakeCourseRepository;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TakeCourseRepository takeCourseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Transactional
    public SuccessResult add(CourseDto courseDto) throws GlobalException {
        try{
            List<Integer> studentIds = courseDto.getStudentIds();

            Course course = new Course(courseDto.getCourseName(),courseDto.getTeacherId(),
                    courseDto.getStartTime(),courseDto.getEndTime(),courseDto.getMark(),
                    courseDto.getCost(),String.valueOf(studentIds.size()));

            course = courseRepository.saveAndFlush(course);

            Integer courseId = course.getId();
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
}
