package com.trainingApplication.core.service;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.dto.TrainingDaysDTO;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.repository.ArrayListTrainingDaysRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAllTrainingDaysService {

    private final ArrayListTrainingDaysRepository repository;

    public FindAllTrainingDaysService(ArrayListTrainingDaysRepository repository) {
        this.repository = repository;
    }

    public FindAllTrainingDaysResponse findAll() {
        var dtos = repository.findAllTrainingDays().stream()
                .map(this::convert)
                .toList();
        return new FindAllTrainingDaysResponse(dtos);
    }

    private TrainingDaysDTO convert(TrainingDaysEntity entity) {
        return new TrainingDaysDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getEventDate());
    }
}
