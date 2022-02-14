package repository;

import domain.UserEntity;

import java.util.List;

public class FileUserRepository implements UserRepository {

    @Override
    public UserEntity save(UserEntity userEntity) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public boolean logIn(String nickName, String password) {
        return false;
    }
}
