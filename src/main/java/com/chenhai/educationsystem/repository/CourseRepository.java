package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
