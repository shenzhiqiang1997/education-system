package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.RequestURL;
import com.chenhai.educationsystem.constant.TemplateId;
import com.chenhai.educationsystem.constant.TemplateMessage;
import com.chenhai.educationsystem.domain.Parent;
import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.domain.template.CourseMessage;
import com.chenhai.educationsystem.domain.template.HomeworkMessage;
import com.chenhai.educationsystem.dto.FeeMessage;
import com.chenhai.educationsystem.dto.MessageElement;
import com.chenhai.educationsystem.dto.TemplateJson;
import com.chenhai.educationsystem.repository.ParentRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.repository.TeacherRepository;
import com.chenhai.educationsystem.repository.template.CourseMessageRepository;
import com.chenhai.educationsystem.repository.template.HomeworkMessageRepository;
import com.chenhai.educationsystem.util.AccessTokenUtil;
import com.chenhai.educationsystem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class TemplateMessageService {
    @Autowired
    private HomeworkMessageRepository homeworkMessageRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseMessageRepository courseMessageRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private AccessTokenUtil accessTokenUtil;
    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private RestTemplate restTemplate;

    private static int tryTime=20;

    public void sendTemplateMessageDaily() throws Exception {
        /*String accessToken=accessTokenUtil.getNewestAccessToken(tryTime);

        if (accessToken==null)
            return;*/

        String accessToken = "9_zdshGy74oH_PvF73TIQGV4kn6PvK1OeqClnyaanhlQo8tji-9ZOGZKcDwN4jdNqk6T43NZkaXxMriDvVCt7BapzKIHCZzkAJaHQIK6fjKz1OiMXa1OY760hFrJjKS2Z5Ml9VNnXoF60WaUNeBLIdABAHRO";

        String templateMessageUrl = RequestURL.TEMPLATE_MESSAGE_URL+accessToken;
        Date tomorrowStartTime = dateUtil.getTomorrowBegin();
        Date tomorrowEndTime = dateUtil.getTomorrowEnd();
        sendHomeworkMessage(templateMessageUrl,tomorrowStartTime,tomorrowEndTime);

        sendCourseMessage(templateMessageUrl,tomorrowStartTime,tomorrowEndTime);
        sendCourseMessageForTeacher(templateMessageUrl,tomorrowStartTime,tomorrowEndTime);
    }

    public void sendTemplateMessageWeekly() throws Exception{
        /*String accessToken=accessTokenUtil.getNewestAccessToken(tryTime);

        if (accessToken==null)
            return;*/

        String accessToken = "9_zdshGy74oH_PvF73TIQGV4kn6PvK1OeqClnyaanhlQo8tji-9ZOGZKcDwN4jdNqk6T43NZkaXxMriDvVCt7BapzKIHCZzkAJaHQIK6fjKz1OiMXa1OY760hFrJjKS2Z5Ml9VNnXoF60WaUNeBLIdABAHRO";

        String templateMessageUrl = RequestURL.TEMPLATE_MESSAGE_URL+accessToken;
        sendFeeMessage(templateMessageUrl);
    }

    private void sendHomeworkMessage(String templateMessageUrl,Date startTime,Date endTime){
        System.out.println(startTime+","+endTime);
        List<HomeworkMessage> homeworkMessageList = homeworkMessageRepository.findAll(startTime,endTime);
        System.out.println("sendHomeworkMessage:"+homeworkMessageList);
        for (HomeworkMessage homeworkMessage:
             homeworkMessageList) {
            String date = homeworkMessage.getDate();
            date = date.substring(0,date.lastIndexOf(" "));

            MessageElement first = new MessageElement(homeworkMessage.getStudentName()+TemplateMessage.HOMEWORK_STUDENT_FIRST);
            MessageElement keyword1 = new MessageElement(date);
            MessageElement keyword2 = new MessageElement(homeworkMessage.getStudentName());
            MessageElement keyword3 = new MessageElement(date+TemplateMessage.HOMEWORK_STUDENT_KEYWORD3);
            MessageElement keyword4 = new MessageElement(TemplateMessage.HOMEWORK_STUDENT_KEYWORD4);
            MessageElement remark = new MessageElement(TemplateMessage.HOMEWORK_REMARK);

            com.chenhai.educationsystem.dto.HomeworkMessage data =
                    new com.chenhai.educationsystem.dto.HomeworkMessage(first,keyword1,keyword2,keyword3,keyword4,remark);

            TemplateJson<com.chenhai.educationsystem.dto.HomeworkMessage> templateJson =
                    new TemplateJson<>(homeworkMessage.getOpenid(),TemplateId.HOMEWORK,data);

            restTemplate.postForObject(templateMessageUrl,templateJson,String.class);
        }
    }

    private void sendFeeMessage(String templateMessageUrl){
        List<Student> studentList = studentRepository.findByRemainingBefore(0);
        for (Student student:
             studentList) {
            MessageElement first = new MessageElement(student.getStudentName()+TemplateMessage.FEE_STUDENT_FIRST);
            MessageElement keyword1 = new MessageElement(student.getStudentName());
            MessageElement keyword2 = new MessageElement(String.valueOf(Math.abs(student.getRemaining())));
            MessageElement remark = new MessageElement(TemplateMessage.FEE_REMARK);

            FeeMessage data = new FeeMessage(first,keyword1,keyword2,remark);
            TemplateJson<FeeMessage> templateJson = new TemplateJson<>(student.getWechatId(),TemplateId.FEE,data);

            restTemplate.postForObject(templateMessageUrl,templateJson,String.class);
            Parent parent = parentRepository.findByStudentId(student.getStudentId());
            if (parent!=null){
                first = new MessageElement(student.getStudentName()+TemplateMessage.FEE_PARENT_FIRST1
                        +student.getStudentName()+TemplateMessage.FEE_PARENT_FIRST2);
                data = new FeeMessage(first,keyword1,keyword2,remark);
                templateJson = new TemplateJson<>(parent.getWechatId(),TemplateId.FEE,data);

                restTemplate.postForObject(templateMessageUrl,templateJson,String.class);
            }
        }
    }

    private void sendCourseMessage(String templateMessageUrl,Date startTime,Date endTime){
        List<Student> studentList = studentRepository.findAll();
        for (Student student:
             studentList) {
            Integer studentId = student.getStudentId();
            System.out.println(studentId);
            List<CourseMessage> courseMessageList = courseMessageRepository.findForStudentByStudentId(studentId,startTime,endTime);

            System.out.println("sendCourseMessage:"+courseMessageList);

            if (courseMessageList!=null&&courseMessageList.size()!=0){
                StringBuffer courseName = new StringBuffer();
                StringBuffer courseTime = new StringBuffer();
                for (CourseMessage courseMessage:
                     courseMessageList) {
                        courseName.append(courseMessage.getCourseName()+"\n");
                        courseTime.append(courseMessage.getCourseName()+" "+courseMessage.getTime()+"\n");
                    }
                MessageElement first = new MessageElement(student.getStudentName()+TemplateMessage.COURSE_STUDENT_FIRST);
                MessageElement keyword1 = new MessageElement(courseName.toString());
                MessageElement keyword2 = new MessageElement(courseTime.toString());
                MessageElement keyword3 = new MessageElement(TemplateMessage.COURSE_KEYWORD3);
                MessageElement remark = new MessageElement(TemplateMessage.COURSE_REMARK);

                com.chenhai.educationsystem.dto.CourseMessage data =
                        new com.chenhai.educationsystem.dto.CourseMessage(first,keyword1,keyword2,keyword3,remark);

                TemplateJson<com.chenhai.educationsystem.dto.CourseMessage> templateJson
                        = new TemplateJson<>(student.getWechatId(),TemplateId.COURSE,data);

                restTemplate.postForObject(templateMessageUrl,templateJson,String.class);

                Parent parent = parentRepository.findByStudentId(studentId);
                System.out.println(parent);
                if (parent!=null){
                    first = new MessageElement(student.getStudentName()+TemplateMessage.COURSE_PARENT_FIRST1
                            +student.getStudentName()+TemplateMessage.COURSE_PARENT_FIRST2);
                    data = new com.chenhai.educationsystem.dto.CourseMessage(first,keyword1,keyword2,keyword3,remark);

                    templateJson = new TemplateJson<>(parent.getWechatId(),TemplateId.COURSE,data);

                    restTemplate.postForObject(templateMessageUrl,templateJson,String.class);
                }
            }
        }
    }

    private void sendCourseMessageForTeacher(String templateMessageUrl,Date startTime,Date endTime){
        List<Teacher> teacherList = teacherRepository.findAll();
        for (Teacher teacher:
                teacherList) {
            System.out.println(teacher.getTeacherId());
            List<CourseMessage> courseMessageList =
                    courseMessageRepository.findForTeacherByTeacherId(teacher.getTeacherId(),startTime,endTime);
            System.out.println("sendCourseMessageForTeacher:"+courseMessageList);
            if (courseMessageList!=null&&courseMessageList.size()!=0){
                    StringBuffer courseName = new StringBuffer();
                    StringBuffer courseTime = new StringBuffer();
                    for (CourseMessage courseMessage:
                            courseMessageList) {
                        courseName.append(courseMessage.getCourseName()+"\n");
                        courseTime.append(courseMessage.getCourseName()+" "+courseMessage.getTime()+"\n");
                    }
                    MessageElement first = new MessageElement(teacher.getTeacherName()+TemplateMessage.COURSE_TEACHER_FIRST);
                    MessageElement keyword1 = new MessageElement(courseName.toString());
                    MessageElement keyword2 = new MessageElement(courseTime.toString());
                    MessageElement keyword3 = new MessageElement(TemplateMessage.COURSE_KEYWORD3);
                    MessageElement remark = new MessageElement(TemplateMessage.COURSE_REMARK);

                    com.chenhai.educationsystem.dto.CourseMessage data =
                            new com.chenhai.educationsystem.dto.CourseMessage(first,keyword1,keyword2,keyword3,remark);

                    TemplateJson<com.chenhai.educationsystem.dto.CourseMessage> templateJson
                            = new TemplateJson<>(teacher.getWechatId(),TemplateId.COURSE,data);

                    restTemplate.postForObject(templateMessageUrl,templateJson,String.class);
                }
        }

    }
}


