package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent,Integer> {
    long countByWechatId(String wechatId);
    long countByMark(String boundId);
    Parent findByMark(String boundId);
}
