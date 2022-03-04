package core;

import domain.UserEntity;
import repository.Repository;

import java.util.List;

public class VerifyUserService {

    private final Repository repository;

    public VerifyUserService(Repository repository) {
        this.repository = repository;
    }

    public UserEntity entrance(String nickName, String password) {
        if (repository.verify(nickName, password)) {
            repository.logIn(repository.getUserEntityByNameAndPassword(nickName, password).getUserId());
            return repository.getUserEntityByNameAndPassword(nickName, password);
        }
        return null;
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
