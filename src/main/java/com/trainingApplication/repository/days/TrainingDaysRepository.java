package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface TrainingDaysRepository {

    TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity);

    List<TrainingDaysEntity> findAllTrainingDays();

    Optional<TrainingDaysEntity> findTrainingDaysById(Long id);

    UserEntity getUserById(Long userId);

    Long addTrainingDaysToUser(Long userId);
}
