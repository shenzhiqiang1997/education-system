package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    long countByWechatId(String wechatId);
    long countByMark(String boundId);
    Teacher findByMark(String boundId);
}
