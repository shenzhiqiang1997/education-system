package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.RenewRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RenewRecordRepository extends JpaRepository<RenewRecord,Integer> {
    List<RenewRecord> findByStudentId(Integer studentId);
}
