package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.Role;
import com.chenhai.educationsystem.domain.Parent;
import com.chenhai.educationsystem.domain.Student;
import com.chenhai.educationsystem.domain.Teacher;
import com.chenhai.educationsystem.domain.User;
import com.chenhai.educationsystem.dto.RoleDto;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.ParentRepository;
import com.chenhai.educationsystem.repository.StudentRepository;
import com.chenhai.educationsystem.repository.TeacherRepository;
import com.chenhai.educationsystem.repository.UserRepository;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ParentRepository parentRepository;

    public SuccessResult login(User user) throws GlobalException{
        Optional<User> optional = userRepository.findById(user.getUsername());
        if (!optional.isPresent())
            throw  new GlobalException(Message.OTHER_ERROR);

        User localUser = optional.get();

        if (StringUtils.isEmpty(localUser.getPassword()))
            throw new GlobalException(Message.OTHER_ERROR);

        if (!localUser.getPassword().equals(user.getPassword()))
            throw new GlobalException(Message.PASSWORD_ERROR);

        return new SuccessResult();
    }

    public SuccessResult add(RoleDto roleDto) throws GlobalException {
        try {
            String character = roleDto.getCharacter();
            String name = roleDto.getName();
            String tel = roleDto.getTel();
            String code = tel.substring(tel.length()-6);
            if (Role.STUDENT.equalsIgnoreCase(character)){
                Student student = new Student();
                student.setStudentName(name);
                student.setCode(code);
                studentRepository.save(student);
                return new SuccessResult();
            } else if (Role.TEACHER.equalsIgnoreCase(character)){
                Teacher teacher = new Teacher();
                teacher.setTeacherName(name);
                teacher.setCode(code);
                teacherRepository.save(teacher);
                return new SuccessResult();
            } else if (Role.PARENT.equalsIgnoreCase(character)){
                Parent parent = new Parent(name,roleDto.getStudentId(),code);
                parentRepository.save(parent);
                return new SuccessResult();
            }

            throw new GlobalException(Message.ERROR);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
