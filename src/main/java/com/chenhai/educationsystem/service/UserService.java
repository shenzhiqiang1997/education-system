package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.domain.User;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
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
}
