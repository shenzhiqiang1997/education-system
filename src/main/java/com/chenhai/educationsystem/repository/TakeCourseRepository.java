package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TakeCourse;
import com.chenhai.educationsystem.domain.TakeCourseKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeCourseRepository extends JpaRepository<TakeCourse,TakeCourseKey> {
}
