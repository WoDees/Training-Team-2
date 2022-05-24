package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.repository.days.TrainingDaysRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FindAllTrainingDaysService {

    private final TrainingDaysRepository repository;

    public FindAllTrainingDaysService(TrainingDaysRepository repository) {
        this.repository = repository;
    }

    public FindAllTrainingDaysResponse findAll() {
        var dtos = repository.findAllTrainingDays().stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return new FindAllTrainingDaysResponse(dtos);
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getTrainingDate());
    }
}
