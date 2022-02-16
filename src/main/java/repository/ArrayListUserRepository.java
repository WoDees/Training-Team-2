package repository;

import domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUserRepository implements UserRepository {

    private List<UserEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setUserId(idSequence);
        idSequence++;
        database.add(userEntity);
        return userEntity;

    }

    @Override
    public List<UserEntity> findAll() {
        return database;
    }

    @Override
    public boolean verify(String nickName, String password) {
        for (UserEntity entity : database) {
            if (entity.getNickName().equals(nickName) && entity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
