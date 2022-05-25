package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindByIdTrainingDaysResponse;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByIdTrainingDaysService {

    private final TrainingDayRepository repository;

    public FindByIdTrainingDaysResponse getById(Long id) {
        return repository.findTrainingDaysById(id)
                .map(this::convert)
                .map(FindByIdTrainingDaysResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("Training day with id " + id + " is not found."));
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getTrainingDate());
    }
}
