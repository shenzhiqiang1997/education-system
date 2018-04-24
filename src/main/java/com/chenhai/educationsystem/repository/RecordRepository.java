package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
