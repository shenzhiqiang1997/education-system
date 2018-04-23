package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Consuming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumingRepository extends JpaRepository<Consuming,Integer> {
    @Query(value = "SELECT s.id AS studentId,c.startTime AS startTime,c.endTime AS endTime,c.type AS type,c.cost AS cost,t.remaining AS remaining " +
            "FROM student AS s LEFT JOIN take_course AS t ON s.id = t.studentId " +
            "LEFT JOIN course AS c ON t.courseId = c.id " +
            "WHERE s.id = ?1",nativeQuery = true)
    List<Consuming> findByStudentId(Integer studentId);
}
