package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;

import java.util.List;
import java.util.Optional;

public interface TrainingDaysRepository {

    TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity);

    List<TrainingDaysEntity> findAllTrainingDays();

    Optional<TrainingDaysEntity> findTrainingDaysById(Long id);

    Long getUserDaysCount(Long userId);
}
