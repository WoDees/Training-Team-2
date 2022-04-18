package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.quiz.QuizValidationService;
import com.trainingApplication.domain.QuizEntity;
import com.trainingApplication.dto.request.QuizRequest;
import com.trainingApplication.dto.response.QuizResponse;
import com.trainingApplication.repository.quiz.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuizRepository repository;
    private final QuizValidationService validationService;

    public QuizService(QuizRepository repository, QuizValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public QuizResponse addQuiz(QuizRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new QuizResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new QuizResponse();
        response.setCreatedQuizId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private QuizEntity convert(QuizRequest request) {
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
