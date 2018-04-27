package com.chenhai.educationsystem.repository.template;

import com.chenhai.educationsystem.domain.template.HomeworkMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HomeworkMessageRepository extends JpaRepository<HomeworkMessage,String> {
    @Query(value = "SELECT CONCAT(s.id,h.id) id,s.wechatId openid,s.name studentName,h.date date,h.name homeworkName FROM student s,homework h " +
            "WHERE str_to_date(h.date,'%Y/%m/%d %H:%i') BETWEEN ?1 AND ?2 " +
            "AND s.id = h.studentId",
    nativeQuery = true)
    List<HomeworkMessage> findAll(Date startTime,Date endTime);
}
