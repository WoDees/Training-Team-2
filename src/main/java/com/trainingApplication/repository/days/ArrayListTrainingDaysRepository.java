package com.trainingApplication.repository.days;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.repository.user.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListTrainingDaysRepository implements TrainingDaysRepository {

    private final Repository repository;
    private final List<TrainingDaysEntity> dataBase = new ArrayList<>();
    private Long sequence = 0L;

    public ArrayListTrainingDaysRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public TrainingDaysEntity save(TrainingDaysEntity trainingDaysEntity) {
        trainingDaysEntity.setId(sequence);
        addDayToUser(trainingDaysEntity);
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
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public Long addTrainingDaysToUser(Long userId) {
        return null;
    }

    @Override
    public List<TrainingDaysEntity> findAllTrainingDays() {
        return dataBase;
    }

    public void addDayToUser(TrainingDaysEntity trainingDaysEntity) {
        var entity = repository.getUserById(trainingDaysEntity.getUserId());
        Long count = 1L;
        entity.setTrainingDaysCount(count + entity.getTrainingDaysCount());
    }
}
