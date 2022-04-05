package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListTrainingDaysRepository implements TrainingDaysRepository {

    private final List<TrainingDaysEntity> dataBase = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        trainingDaysEntity.setId(sequence);
        trainingDaysEntity.getUserId();
        sequence++;
        dataBase.add(trainingDaysEntity);
        return trainingDaysEntity;
    }

    @Override
    public Optional<TrainingDaysEntity> findTrainingDaysById(Long id) {
        return dataBase.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<TrainingDaysEntity> findAllTrainingDays() {
        return dataBase;
    }
}
