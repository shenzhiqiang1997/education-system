package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework,Integer> {
}
