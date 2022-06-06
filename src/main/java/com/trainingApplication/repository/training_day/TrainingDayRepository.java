package com.trainingApplication.repository.training_day;

import com.trainingApplication.domain.TrainingDaysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TrainingDayRepository extends JpaRepository<TrainingDaysEntity, Long>, JpaSpecificationExecutor<TrainingDaysEntity> {

    List<TrainingDaysEntity> findAllByTrainingDate(String name);

    Optional<TrainingDaysEntity> findFirstByTrainingDate(String name);

    Optional<TrainingDaysEntity> findTrainingDaysById(Long id);
}
