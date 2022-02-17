package repository;

import domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTrainingDaysRepository implements UserRepository {

    private final List<UserEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setTrainingDayAmount(idSequence);
        idSequence++;
        database.add(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        return database;
    }

    @Override
    public boolean logIn(String nickName, String password) {
        return false;
    }
}
