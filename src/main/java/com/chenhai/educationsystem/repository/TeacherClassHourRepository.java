package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TeacherClassHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherClassHourRepository extends JpaRepository<TeacherClassHour,Integer> {
    List<TeacherClassHour> findByTeacherId(Integer teacherId);
}
