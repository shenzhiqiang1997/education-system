package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumptionRepository extends JpaRepository<Consumption,Integer> {
    @Query(value = "SELECT CONCAT(s.id,c.id) AS id,c.startTime AS date, " +
            "c.type AS type,c.cost AS cost,t.remaining AS remaining,ch.duration AS period " +
            "FROM student s,take_course t,course c,classhour ch " +
            "WHERE s.id = ?1 AND s.id = t.studentId AND t.courseId = c.id " +
            "AND c.id = ch.courseId",nativeQuery = true)
    List<Consumption> findByStudentId(Integer studentId);
}
