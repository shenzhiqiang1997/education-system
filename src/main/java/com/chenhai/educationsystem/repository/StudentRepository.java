package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByStudentId(Integer studentId);
}
