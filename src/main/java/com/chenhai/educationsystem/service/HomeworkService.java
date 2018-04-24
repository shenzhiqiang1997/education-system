package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.BasePath;
import com.chenhai.educationsystem.domain.Homework;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.HomeworkRepository;
import com.chenhai.educationsystem.vo.SuccessResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;

    @Transactional
    public SuccessResult add(MultipartFile multipartFile, String name, String content, String date, String studentIds) throws GlobalException {
        try {
            byte[] bytes = multipartFile.getBytes();
            String pics = BasePath.HOME_WORK_FOLDER + multipartFile.getOriginalFilename();
            Path path = Paths.get(pics);
            Path basePath = Paths.get(BasePath.HOME_WORK_FOLDER);
            if (!Files.exists(basePath))
                Files.createDirectory(basePath);

            Files.write(path,bytes);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Integer> studentIdList = objectMapper.readValue(studentIds,new TypeReference<List<Integer>>(){});
            for (Integer studentId:
                 studentIdList) {
                Homework homework = new Homework(name,content,date,pics,studentId);
                homeworkRepository.save(homework);
            }

            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
