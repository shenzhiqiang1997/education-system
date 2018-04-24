package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FeeRepository extends JpaRepository<Fee,Integer> {
    @Query(value = "SELECT id AS id,SUM(cost) total FROM record " +
            "WHERE student_id = ?1 " +
            "AND STR_TO_DATE(start_time,'%Y-%m-%d %H:%i') " +
            "BETWEEN ?2 AND ?3" , nativeQuery = true)
    Fee findByStudentId(Integer studentId, Date ST, Date ET);
}
