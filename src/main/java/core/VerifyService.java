package core;

import domain.UserEntity;
import repository.Repository;

import java.util.List;

public class VerifyService {

    private final Repository repository;

    public VerifyService(Repository repository) {
        this.repository = repository;
    }

    public UserEntity entrance(String nickName, String password) {

        if (repository.verify(nickName, password)) {
            System.out.println("Log in successful");
            repository.getUserEntity(nickName, password);
        }
        return null;
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
