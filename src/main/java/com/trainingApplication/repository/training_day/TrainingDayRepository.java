package com.trainingApplication.repository.training_day;

import com.trainingApplication.domain.TrainingDaysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingDayRepository extends JpaRepository<TrainingDaysEntity, Long> {

    List<TrainingDaysEntity> findAll();

    Optional<TrainingDaysEntity> findTrainingDaysById(Long id);
}
