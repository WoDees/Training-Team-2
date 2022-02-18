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

    @Override
    public boolean remove(String login, String password) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getNickName().equals(login) && database.get(i).getPassword().equals(password)) {
                database.remove(i);
                return true;
            }
        }
        return false;
    }
}
