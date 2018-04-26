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
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FeedbackService {
    @Autowired
    private CourseFeedbackRepository courseFeedbackRepository;
    @Autowired
    private HomeworkFeedbackRepository homeworkFeedbackRepository;
    @Autowired
    private TestFeedbackRepository testFeedbackRepository;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");

    @Transactional
    public SuccessResult add(String studentId, String name, String feedback,
                             MultipartFile multipartFile, String type) throws GlobalException {
        try {
            String fileName = multipartFile.getOriginalFilename();
            byte[] bytes = multipartFile.getBytes();
            Date timestamp = new Date();
            if (Type.COURSE_FEEDBACK.equalsIgnoreCase(type)){
                String localPics = BasePath.COURSE_FEEDBACK_FOLDER+sdf.format(timestamp) + fileName;
                String remotePics = BasePath.COURSE_FEEDBACK_URL+sdf.format(timestamp) +fileName;
                Path basePath = Paths.get(BasePath.COURSE_FEEDBACK_FOLDER);
                Path path = Paths.get(localPics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);

                Files.write(path,bytes);

                CourseFeedback courseFeedback = new CourseFeedback(studentId,feedback, remotePics,name);
                courseFeedbackRepository.save(courseFeedback);

                return new SuccessResult();
            } else if (Type.HOMEWORK_FEEDBACK.equalsIgnoreCase(type)){
                String localPics = BasePath.HOMEWORK_FEEDBACK_FOLDER+sdf.format(timestamp) +fileName;
                String remotePics = BasePath.HOMEWORK_FEEDBACK_URL+sdf.format(timestamp) + fileName;
                Path basePath = Paths.get(BasePath.HOMEWORK_FEEDBACK_FOLDER);
                Path path = Paths.get(localPics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);
                Files.write(path,bytes);

                HomeworkFeedback homeworkFeedback = new HomeworkFeedback(studentId,feedback, remotePics,name);
                homeworkFeedbackRepository.save(homeworkFeedback);

                return new SuccessResult();
            } else if (Type.TEST_FEEDBACK.equalsIgnoreCase(type)){
                String localPics = BasePath.TEST_FEEDBACK_FOLDER+sdf.format(timestamp) +fileName;
                String remotePics = BasePath.TEST_FEEDBACK_URL+sdf.format(timestamp) + fileName;
                Path basePath = Paths.get(BasePath.TEST_FEEDBACK_FOLDER);
                Path path = Paths.get(localPics);
                if (!Files.exists(basePath))
                    Files.createDirectory(basePath);
                Files.write(path,bytes);

                TestFeedback testFeedback = new TestFeedback(studentId,feedback, remotePics,name);
                testFeedbackRepository.save(testFeedback);

                return new SuccessResult();
            }

            throw new GlobalException(Message.ERROR);
        } catch (Exception e){
            throw new GlobalException(Message.ERROR);
        }
    }
}
