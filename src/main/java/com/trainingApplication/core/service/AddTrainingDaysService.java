package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import com.trainingApplication.dto.response.AddTrainingDaysResponse;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddTrainingDaysService {

    private final TrainingDayRepository repository;

    public AddTrainingDaysResponse add(AddTrainingDaysRequest request) {
        log.info("Received request: {}", request);
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        log.info("Successfully saved: {}", createdEntity);
        var response = new AddTrainingDaysResponse();
        response.setCreatedTrainingDaysId(createdEntity.getId());
        log.debug("Sending response: {}", response);
        return response;
    }

    private TrainingDaysEntity convert(AddTrainingDaysRequest request) {
        var entity = new TrainingDaysEntity();
        entity.setTrainingDay(request.getTrainingDay());
        entity.setDescription(request.getDescription());
        entity.setUserId(request.getUserId());
        return entity;
    }
}
