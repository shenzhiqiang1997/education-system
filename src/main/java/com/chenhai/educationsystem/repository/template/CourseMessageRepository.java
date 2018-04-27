package com.chenhai.educationsystem.repository.template;

import com.chenhai.educationsystem.domain.template.CourseMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CourseMessageRepository extends JpaRepository<CourseMessage,String> {
    @Query(value = "SELECT CONCAT(c.id,s.id) AS id,s.wechatId openid," +
            "s.name personName,c.name courseName,c.startTime time " +
            "FROM course c,take_course tc,student s " +
            "WHERE s.id =?1 AND STR_TO_DATE(c.startTime,'%Y/%m/%d %H:%i') BETWEEN ?2 AND ?3 " +
            "AND c.id = tc.courseId AND tc.studentId = s.id",nativeQuery = true)
    List<CourseMessage> findForStudentByStudentId(Integer studentId,Date startTime,Date endTime);

    @Query(value = "SELECT c.id id,t.wechatId openid, " +
            "t.name personName,c.name courseName, " +
            "c.startTime time " +
            "FROM course c,teacher t " +
            "WHERE t.id =?1 AND STR_TO_DATE(c.startTime,'%Y/%m/%d %H:%i') BETWEEN ?2 AND ?3 " +
            "AND c.teacherId=t.id ",nativeQuery = true)
    List<CourseMessage> findForTeacherByTeacherId(Integer teacherId,Date startTime,Date endTime);
}
