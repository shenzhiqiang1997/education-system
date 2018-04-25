package com.chenhai.educationsystem.schedule;

import com.chenhai.educationsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {
    @Autowired
    private HomeworkService homeworkService;

    @Scheduled(cron = "0 0 0 * * ?")
    /*@Scheduled(initialDelay = 10000,fixedRate = 5000)*/
    public void homeworkDeleteScheduler() throws Exception {
        homeworkService.deleteOnSchedule();
    }
}
