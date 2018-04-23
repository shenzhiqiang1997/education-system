package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FeeRepository extends JpaRepository<Fee,Integer> {
    @Query(value = "SELECT s.id AS id,SUM(c.cost) AS total FROM take_course t,course c,student s " +
            "WHERE s.id = ?1 AND s.id =t.studentId AND c.id = t.courseId " +
            "AND STR_TO_DATE(c.startTime,'%Y-%m-%d %H:%i:%s') " +
            "BETWEEN ?2 AND ?3" , nativeQuery = true)
    Fee findByStudentId(Integer studentId, Date ST, Date ET);
}
