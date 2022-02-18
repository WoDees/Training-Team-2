package repository;

import domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUserRepository implements Repository {

    private List<UserEntity> dataBase = new ArrayList<>();
    private Long idSequence = 0L;

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setUserId(idSequence);
        idSequence++;
        dataBase.add(userEntity);
        return userEntity;

    }

    @Override
    public List<UserEntity> findAll() {
        return dataBase;
    }

    @Override
    public boolean verify(String nickName, String password) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickName().equals(nickName) && entity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(String login, String password) {
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).getNickName().equals(login) && dataBase.get(i).getPassword().equals(password)) {
                dataBase.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserEntity getUserEntity(String nickName, String password) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickName().equals(nickName) && entity.getPassword().equals(password)) {
                return entity;
            }
        }
        return null;
    }
}
