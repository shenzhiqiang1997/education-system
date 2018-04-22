package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework,Integer> {
}
