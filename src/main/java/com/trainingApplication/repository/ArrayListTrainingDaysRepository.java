package com.trainingApplication.repository;

import com.trainingApplication.domain.TrainingDaysEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ArrayListTrainingDaysRepository {

    private final List<TrainingDaysEntity> dataBase = new ArrayList<>();
    private Long sequence = 0L;

    public List<TrainingDaysEntity> findCalendarsByUserId(Long id) {

        List<TrainingDaysEntity> userDays = new ArrayList<>();

        for (TrainingDaysEntity calendar : dataBase) {
            if (Objects.equals(calendar.getUserId(), id)) {
                userDays.add(calendar);
            }
        }
        return userDays;
    }

    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        trainingDaysEntity.setUserId(sequence);
        sequence++;
        dataBase.add(trainingDaysEntity);
        return trainingDaysEntity;
    }

    public List<TrainingDaysEntity> findAllTrainingDays() {
        return dataBase;
    }
}
