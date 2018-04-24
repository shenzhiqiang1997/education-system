package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumptionRepository extends JpaRepository<Consumption,Integer> {
    List<Consumption> findByStudentId(Integer studentId);
}
