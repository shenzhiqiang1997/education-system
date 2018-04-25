package com.chenhai.educationsystem.service;

import com.chenhai.educationsystem.constant.BasePath;
import com.chenhai.educationsystem.constant.Type;
import com.chenhai.educationsystem.domain.CourseFeedback;
import com.chenhai.educationsystem.domain.HomeworkFeedback;
import com.chenhai.educationsystem.domain.TestFeedback;
import com.chenhai.educationsystem.exception.GlobalException;
import com.chenhai.educationsystem.message.Message;
import com.chenhai.educationsystem.repository.CourseFeedbackRepository;
import com.chenhai.educationsystem.repository.HomeworkFeedbackRepository;
import com.chenhai.educationsystem.repository.TestFeedbackRepository;
import com.chenhai.educationsystem.vo.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FeedbackService {
    @Autowired
    private CourseFeedbackRepository courseFeedbackRepository;
    @Autowired
    private HomeworkFeedbackRepository homeworkFeedbackRepository;
    @Autowired
    private TestFeedbackRepository testFeedbackRepository;

    @Transactional
    public SuccessResult add(String studentId, String feedback,
                             MultipartFile multipartFile, String type) throws GlobalException {
        try {
            String fileName = multipartFile.getOriginalFilename();
            byte[] bytes = multipartFile.getBytes();
            if (Type.COURSE_FEEDBACK.equalsIgnoreCase(type)){
                String pics = BasePath.COURSE_FEEDBACK_FOLDER + fileName;
                Path basePath = Paths.get(BasePath.COURSE_FEEDBACK_FOLDER);
                Path path = Paths.get(pics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);

                Files.write(path,bytes);

                CourseFeedback courseFeedback = new CourseFeedback(studentId,feedback,pics);
                courseFeedbackRepository.save(courseFeedback);

                return new SuccessResult();
            } else if (Type.HOMEWORK_FEEDBACK.equalsIgnoreCase(type)){
                String pics = BasePath.HOME_WORK_FOLDER + fileName;
                Path basePath = Paths.get(BasePath.HOMEWORK_FEEDBACK_FOLDER);
                Path path = Paths.get(pics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);
                Files.write(path,bytes);

                HomeworkFeedback homeworkFeedback = new HomeworkFeedback(studentId,feedback,pics);
                homeworkFeedbackRepository.save(homeworkFeedback);

                return new SuccessResult();
            } else if (Type.TEST_FEEDBACK.equalsIgnoreCase(type)){
                String pics = BasePath.TEST_FEEDBACK_FOLDER + fileName;
                Path basePath = Paths.get(BasePath.TEST_FEEDBACK_FOLDER);
                Path path = Paths.get(pics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);
                Files.write(path,bytes);

                TestFeedback testFeedback = new TestFeedback(studentId,feedback,pics);
                testFeedbackRepository.save(testFeedback);

                return new SuccessResult();
            }

            throw new GlobalException(Message.ERROR);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
