package core;

import repository.FileUserRepository;
import repository.UserRepository;

public class ActivitiesCaloriesService {

    private final UserRepository repository;

    public ActivitiesCaloriesService(UserRepository repository) {
        this.repository = repository;
    }
}
