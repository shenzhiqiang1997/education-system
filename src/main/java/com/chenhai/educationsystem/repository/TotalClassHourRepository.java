package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.TotalClassHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface TotalClassHourRepository extends JpaRepository<TotalClassHour,Integer> {
    @Query(value = "SELECT id,SUM(period) total FROM record WHERE id IN " +
            "( SELECT MIN(id) FROM record WHERE teacher_id=?1 AND type =?2 GROUP BY course_id );",nativeQuery = true)
    TotalClassHour findByTeacherIdAndType(Integer teacherId,String type);
    @Query(value = "SELECT id,SUM(period) total FROM record WHERE id IN " +
            "( SELECT MIN(id) FROM record WHERE teacher_id =?1 AND str_to_date(start_time,'%Y/%m/%d %H:%i') BETWEEN ?2 AND ?3 GROUP BY course_id)",nativeQuery = true)
    TotalClassHour findByTeacherIdAndTimeInterval(Integer teacherId,Date startTime,Date endTime);
}
