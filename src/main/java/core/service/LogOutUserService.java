package core.service;

import domain.UserEntity;
import repository.Repository;

import java.util.List;

public class LogOutUserService {

    private final Repository repository;

    public LogOutUserService(Repository repository) {
        this.repository = repository;
    }

    public void logOut(Long userId) {
        repository.logOut(userId);
    }
}
