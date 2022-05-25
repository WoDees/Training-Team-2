package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindAllTrainingDaysService {

    private final TrainingDayRepository repository;

    public FindAllTrainingDaysResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return new FindAllTrainingDaysResponse(dtos);
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getTrainingDate());
    }
}
