package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;

import java.util.List;
import java.util.Optional;

public interface TrainingDaysRepository {

    TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity);

    List<TrainingDaysEntity> findAllTrainingDays();

    Optional<TrainingDaysEntity> findTrainingDaysById(Long id);
}
