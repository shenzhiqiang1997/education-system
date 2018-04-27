package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.RequestParameter;
import com.chenhai.educationsystem.constant.RequestURL;
import com.chenhai.educationsystem.constant.Role;
import com.chenhai.educationsystem.domain.Parent;
import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.dto.CodeDto;
import com.chenhai.educationsystem.dto.OpenidDto;
import com.chenhai.educationsystem.dto.OpenidIdentityDto;
import com.chenhai.educationsystem.dto.OpenidJson;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.ParentRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.repository.TeacherRepository;
import com.chenhai.educationsystem.vo.IdentityResult;
import com.chenhai.educationsystem.vo.OpenidResult;
import com.chenhai.educationsystem.vo.SuccessMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Service
public class OpenidService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public OpenidResult get(CodeDto codeDto) throws Exception {
        String code = codeDto.getCode();

        String openidUrl = RequestURL.OPENID_URL
                .replace("APPID",RequestParameter.APP_ID)
                .replace("SECRET",RequestParameter.SECRET)
                .replace("CODE",code);

        String openidJsonString = restTemplate.getForObject(openidUrl,String.class);
        ObjectMapper mapper = new ObjectMapper();
        OpenidJson openidJson = mapper.readValue(openidJsonString,OpenidJson.class);
        return new OpenidResult(openidJson.getOpenid());
    }


    public IdentityResult identify(OpenidDto openidDto) throws GlobalException {
        try {
            String openid = openidDto.getOpenid();
            if (studentRepository.countByWechatId(openid)!=0)
                return new IdentityResult(Role.STUDENT);
            if (parentRepository.countByWechatId(openid)!=0)
                return new IdentityResult(Role.PARENT);
            if (teacherRepository.countByWechatId(openid)!=0)
                return new IdentityResult(Role.TEACHER);

            throw new Exception();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    public SuccessMessageResult bind(OpenidIdentityDto openidIdentityDto) throws Exception{
        String openid = openidIdentityDto.getOpenid();
        String boundId =openidIdentityDto.getBoundId();

        if (studentRepository.countByMark(boundId)!=0){
            Student student = studentRepository.findByMark(boundId);

            if (student.getWechatId()!=null)
                throw new GlobalException(Message.HAD_BOUND_ERROR);

            student.setWechatId(openid);
            studentRepository.save(student);
            return new SuccessMessageResult(Message.BOUND_SUCCESS);
        }else if (parentRepository.countByMark(boundId)!=0){
            Parent parent = parentRepository.findByMark(boundId);

            if (parent.getWechatId()!=null)
                throw new GlobalException(Message.HAD_BOUND_ERROR);

            parent.setWechatId(openid);
            parentRepository.save(parent);
            return new SuccessMessageResult(Message.BOUND_SUCCESS);
        }else if (teacherRepository.countByMark(boundId)!=0){
            Teacher teacher = teacherRepository.findByMark(boundId);

            if (teacher.getWechatId()!=null)
                throw new GlobalException(Message.HAD_BOUND_ERROR);

            teacher.setWechatId(openid);
            teacherRepository.save(teacher);
            return new SuccessMessageResult(Message.BOUND_SUCCESS);
        }else {
            throw new GlobalException(Message.BOUND_ID_ERROR);
        }
    }
}
