package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindByIdTrainingDaysResponse;
import com.trainingApplication.repository.days.TrainingDaysRepository;
import org.springframework.stereotype.Service;

@Service
public class FindByIdTrainingDaysService {

    private final TrainingDaysRepository repository;

    public FindByIdTrainingDaysService(TrainingDaysRepository repository) {
        this.repository = repository;
    }

    public FindByIdTrainingDaysResponse getById(Long id) {
        return repository.findTrainingDaysById(id)
                .map(this::convert)
                .map(FindByIdTrainingDaysResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("Training Day with id " + id + " is not found."));
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getTrainingDate());
    }
}
