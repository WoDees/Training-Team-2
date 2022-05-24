package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.trainingDays.TrainingDaysValidationService;
import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import com.trainingApplication.dto.response.AddTrainingDaysResponse;
import com.trainingApplication.repository.days.TrainingDaysRepository;
import org.springframework.stereotype.Service;

@Service
public class AddTrainingDaysService {

    private final TrainingDaysRepository repository;
    private final TrainingDaysValidationService validationService;

    public AddTrainingDaysService(TrainingDaysRepository repository, TrainingDaysValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddTrainingDaysResponse add(AddTrainingDaysRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingDaysResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddTrainingDaysResponse();
        response.setCreatedTrainingDaysId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private TrainingDaysEntity convert(AddTrainingDaysRequest request) {
        var entity = new TrainingDaysEntity();
        entity.setTrainingDate(request.getTrainingDate());
        entity.setDescription(request.getDescription());
        entity.setUserId(request.getUserId());
        return entity;
    }
}
