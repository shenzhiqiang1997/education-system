package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TotalClassHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface TotalClassHourRepository extends JpaRepository<TotalClassHour,Integer> {
    @Query(value = "SELECT ch.id id,SUM(ch.duration) total " +
            "FROM course c,classhour ch WHERE c.teacherId =?1 AND c.type =?2 " +
            "AND c.id=ch.courseId",nativeQuery = true)
    TotalClassHour findByTeacherIdAndType(Integer teacherId,String type);
    @Query(value = "SELECT ch.id id,SUM(ch.duration) total " +
            "FROM course c,classhour ch " +
            "WHERE c.teacherId =?1 AND c.startTime BETWEEN ?2 " +
            "AND ?3 AND c.id = ch.courseId",nativeQuery = true)
    TotalClassHour findByTeacherIdAndTimeInterval(Integer teacherId,Date startTime,Date endTime);
}
