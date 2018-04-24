package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TotalClassHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface TotalClassHourRepository extends JpaRepository<TotalClassHour,Integer> {
    @Query(value = "SELECT id,SUM(period) total FROM record " +
            "WHERE teacher_id =?1 AND type=?2 ",nativeQuery = true)
    TotalClassHour findByTeacherIdAndType(Integer teacherId,String type);
    @Query(value = "SELECT id,SUM(period) total FROM record " +
            "WHERE teacher_id =?1 AND start_time BETWEEN ?2 " +
            "AND ?3",nativeQuery = true)
    TotalClassHour findByTeacherIdAndTimeInterval(Integer teacherId,Date startTime,Date endTime);
}
