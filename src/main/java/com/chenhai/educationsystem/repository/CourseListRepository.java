package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.CourseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseListRepository extends JpaRepository<CourseList,String> {
    @Query(value = "SELECT CONCAT(s.id,c.id,t.id) id,s.id studentId, " +
            "c.id courseId,t.id teacherId,s.name student,c.name courseName, " +
            "t.name teacher,c.startTime startTime,c.endTime endTime,c.type type, " +
            "c.cost fee,ch.duration period,c.description mark " +
            "FROM course c,take_course tc,student s,teacher t,classhour ch " +
            "WHERE c.id =tc.courseId AND tc.studentId = s.id " +
            "AND t.id = c.teacherId AND ch.courseId = c.id",
            nativeQuery = true)
    List<CourseList> findAll();
}
