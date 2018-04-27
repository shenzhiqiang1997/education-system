package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByStudentId(Integer studentId);
    long countByWechatId(String wechatId);
    long countByMark(String boundId);
    Student findByMark(String boundId);
    List<Student> findByRemainingBefore(Integer reaming);
}
