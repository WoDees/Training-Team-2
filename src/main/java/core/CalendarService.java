package core;

import domain.UserEntity;
import repository.UserRepository;

import java.util.List;

public class CalendarService {

    public final UserRepository repository;

    public CalendarService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveTrainingDays(UserEntity userEntity) {
        repository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}