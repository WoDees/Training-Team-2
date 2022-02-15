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
    public boolean logIn(String nickName, String password) {

        for (UserEntity entity : database) {
            if (entity.getNickName().equals(nickName) && entity.getPassword().equals(password)) {
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("Wrong nickname or password or user does not exist!");
        return false;
    }
}
