package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.quiz.QuizValidationService;
import com.trainingApplication.domain.QuizEntity;
import com.trainingApplication.dto.request.AddQuizRequest;
import com.trainingApplication.dto.response.AddQuizResponse;
import com.trainingApplication.repository.quiz.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class AddQuizService {

    private final QuizRepository repository;
    private final QuizValidationService validationService;

    public AddQuizService(QuizRepository repository, QuizValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddQuizResponse addQuiz(AddQuizRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddQuizResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddQuizResponse();
        response.setCreatedQuizId(createdEntity.getId());
        System.out.println("Sending response: " + response);
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
