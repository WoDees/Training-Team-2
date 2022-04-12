package com.trainingApplication.repository.user;

import com.trainingApplication.domain.TrainingDaysEntity;
import com.trainingApplication.domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUserRepository implements Repository {

    private final List<UserEntity> dataBase = new ArrayList<>();
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
    public boolean remove(String nickname, String password) {
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.get(i).getNickname().equals(nickname) && dataBase.get(i).getPassword().equals(password)) {
                dataBase.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickname().equals(nickname) && entity.getPassword().equals(password)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        for (UserEntity entity : dataBase) {
            if (entity.getUserId().equals(userId)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean logOut(Long userId) {
        getUserById(userId).setOnlineStatus(false);
        return false;
    }

    @Override
    public boolean logIn(Long userId) {
        getUserById(userId).setOnlineStatus(true);
        return true;
    }

    @Override
    public UserEntity getUserByNickName(String nickname) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickname().equals(nickname)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public UserEntity getUserByMail(String mail) {
        for (UserEntity entity : dataBase) {
            if (entity.getMail().equals(mail)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean verifyUserByNickname(String nickname) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verifyUserByPassword(String password) {
        for (UserEntity entity : dataBase) {
            if (entity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsUserByMail(String mail) {
        return false;
    }

    @Override
    public boolean existsUserByNickname(String nickname) {
        return false;
    }

    @Override
    public void addTrainingDaysToUser(TrainingDaysEntity trainingDaysEntity) {

    }

    @Override
    public Long getUserDaysCount(Long userId) {
        return null;
    }
}

