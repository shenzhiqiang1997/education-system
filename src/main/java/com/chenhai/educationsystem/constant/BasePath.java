package com.chenhai.educationsystem.constant;

public interface BasePath {
    String STATIC_RESOURCE_FOLDER ="C:/static/";
    String HOME_WORK_FOLDER = STATIC_RESOURCE_FOLDER+"homework/";
    String COURSE_FEEDBACK_FOLDER=STATIC_RESOURCE_FOLDER+"coursefeedback/";
    String HOMEWORK_FEEDBACK_FOLDER=STATIC_RESOURCE_FOLDER+"homeworkfeedback/";
    String TEST_FEEDBACK_FOLDER=STATIC_RESOURCE_FOLDER+"testfeedback/";
    String STATIC_RESOURCE_BASE_URL="https://chenhaijiaowu:8081/";
    String HOME_WORK_URL=STATIC_RESOURCE_BASE_URL+"homework/";
    String COURSE_FEEDBACK_URL=STATIC_RESOURCE_BASE_URL+"coursefeedback/";
    String HOMEWORK_FEEDBACK_URL=STATIC_RESOURCE_BASE_URL+"homeworkfeedback/";
    String TEST_FEEDBACK_URL=STATIC_RESOURCE_BASE_URL+"testfeedback/";
}
