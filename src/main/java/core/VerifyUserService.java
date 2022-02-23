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
            return repository.getUserEntity(nickName, password);
        }
        return null;
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
