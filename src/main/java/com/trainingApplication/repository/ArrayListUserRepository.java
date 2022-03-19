package com.trainingApplication.repository;

import com.trainingApplication.domain.CalendarEntity;
import com.trainingApplication.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class ArrayListUserRepository implements Repository {

    private final List<UserEntity> dataBase = new ArrayList<>();
    private Long idSequence = 0L;



    private final List<CalendarEntity> calendarDataBase = new ArrayList<>();


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
    public boolean verify(String nickname, String password) {
        for (UserEntity entity : dataBase) {
            if (entity.getNickname().equals(nickname) && entity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
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
    public void logIn(Long userId) {
        getUserById(userId).setOnlineStatus(true);
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
    public void addCalendarToUser(Long userId, CalendarEntity entity) {
        var calendars = new ArrayList<CalendarEntity>();
        getUserById(userId).setCalendarEntityList(calendars);
    }
}
