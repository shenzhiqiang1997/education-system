package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.CourseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseListRepository extends JpaRepository<CourseList,String> {
    @Query(value = "SELECT CONCAT(tc.studentId,tc.courseId) AS id,t.name AS teacher,c.name AS courseName, " +
            "c.startTime AS startTime,c.endTime AS endTime,c.id AS courseId, " +
            "s.name AS student FROM course c,take_course tc,student s,teacher t " +
            "WHERE c.id =tc.courseId AND tc.studentId = s.id AND t.id = c.teacherId",
            nativeQuery = true)
    List<CourseList> findAll();
}
