package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TeacherClassHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherClassHourRepository extends JpaRepository<TeacherClassHour,Integer> {
    @Query(value = "SELECT s.id id,c.startTime date,c.type type, " +
            "ch.duration period,c.description mark,s.name student " +
            "FROM course c,take_course t,student s,classhour ch " +
            "WHERE c.teacherId = ?1 AND c.id = t.courseId " +
            "AND s.id = t.studentId AND c.id = ch.courseId",nativeQuery = true)
    List<TeacherClassHour> findAllByTeacherId(Integer teacherId);
}
