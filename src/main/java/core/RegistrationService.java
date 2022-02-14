package core;

import domain.UserEntity;
import repository.UserRepository;

public class RegistrationService {

    private final UserRepository repository;

    public RegistrationService(UserRepository repository) {
        this.repository = repository;
    }

    public void add(UserEntity entity) {
        repository.save(entity);
    }
}
