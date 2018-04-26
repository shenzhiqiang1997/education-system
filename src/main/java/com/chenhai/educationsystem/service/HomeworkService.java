package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.BasePath;
import com.chenhai.educationsystem.domain.Homework;
import com.chenhai.educationsystem.domain.HomeworkDeleting;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.HomeworkDeletingRepository;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private HomeworkDeletingRepository homeworkDeletingRepository;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");

    @Transactional(rollbackFor = Exception.class)
    public SuccessResult add(MultipartFile multipartFile, String name, String content, String date, String studentIds) throws GlobalException {
        try {
            byte[] bytes = multipartFile.getBytes();
            Date timestamp = new Date();
            String localPics = BasePath.HOME_WORK_FOLDER+sdf.format(timestamp)+multipartFile.getOriginalFilename();
            String remotePics = BasePath.HOME_WORK_URL+sdf.format(timestamp)+multipartFile.getOriginalFilename();
            Path path = Paths.get(localPics);
            Path basePath = Paths.get(BasePath.HOME_WORK_FOLDER);
            if (!Files.exists(basePath))
                Files.createDirectory(basePath);

            Files.write(path,bytes);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Integer> studentIdList = objectMapper.readValue(studentIds,new TypeReference<List<Integer>>(){});
            for (Integer studentId:
                 studentIdList) {
                Homework homework = new Homework(name,content,date, remotePics,studentId);
                homeworkRepository.save(homework);
            }

            return new SuccessResult();
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteOnSchedule() throws Exception{
        List<HomeworkDeleting> homeworkList = homeworkDeletingRepository.findTimeoutList();
        for (HomeworkDeleting homework:
                homeworkList) {
            String filePath = homework.getPics();
            Path path = Paths.get(filePath.replace(BasePath.STATIC_RESOURCE_BASE_URL,BasePath.STATIC_RESOURCE_FOLDER));

            if (Files.exists(path))
                Files.delete(path);
        }

        if (homeworkList != null&& homeworkList.size() != 0)
            homeworkDeletingRepository.deleteTimeoutList();
    }
}
