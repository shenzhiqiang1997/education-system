package com.chenhai.educationsystem.schedule;

import com.chenhai.educationsystem.service.HomeworkService;
import com.chenhai.educationsystem.service.TemplateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private TemplateMessageService templateMessageService;

    @Scheduled(cron = "0 0 0 * * ?")
    /*@Scheduled(initialDelay = 10000,fixedRate = 5000)*/
    public void homeworkDeleteScheduler() throws Exception {
        homeworkService.deleteOnSchedule();
    }

    /*@Scheduled(cron = "0 0 19 * * ?")*/
    @Scheduled(initialDelay = 10000,fixedRate = 20000)
    public void templateMessageDailyScheduler() throws Exception{
        templateMessageService.sendTemplateMessageDaily();
    }

    /*@Scheduled(cron = "0 0 7 ? * MON")*//*
    @Scheduled(initialDelay = 10000,fixedRate = 20000)
    public void templateMessageWeeklyScheduler() throws Exception{
        templateMessageService.sendTemplateMessageWeekly();
    }*/
}
