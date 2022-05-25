package com.trainingApplication.core.service;

import com.trainingApplication.domain.QuizEntity;
import com.trainingApplication.dto.request.AddQuizRequest;
import com.trainingApplication.dto.response.AddQuizResponse;
import com.trainingApplication.repository.quiz.QuizRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddQuizService {

    private final QuizRepository repository;

    public AddQuizResponse addQuiz(AddQuizRequest request) {
        log.info("Received request: {}", request);
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        log.info("Successfully saved: {}", createdEntity);
        var response = new AddQuizResponse();
        response.setCreatedQuizId(createdEntity.getId());
        log.debug("Sending response: {}", response);
        return response;
    }

    private QuizEntity convert(AddQuizRequest request) {
        var entity = new QuizEntity();
        entity.setGender(request.getGender());
        entity.setAge(request.getAge());
        entity.setWeight(request.getWeight());
        entity.setGrowth(request.getGrowth());
        entity.setDesiredWeight(request.getDesiredWeight());
        entity.setTarget(request.getTarget());
        entity.setUserId(request.getUserId());
        return entity;
    }
}
