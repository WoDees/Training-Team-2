package core;

import domain.UserEntity;
import repository.Repository;

public class RegistrationService {

    private final Repository repository;

    public RegistrationService(Repository repository) {
        this.repository = repository;
    }

    public void add(UserEntity entity) {
        repository.save(entity);
    }
}
