package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.CourseReference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseReferenceRepository extends JpaRepository<CourseReference,Integer> {
    long countByCourseId(Integer courseId);
}
