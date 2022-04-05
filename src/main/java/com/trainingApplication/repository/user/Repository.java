package com.trainingApplication.repository.user;

import com.trainingApplication.domain.UserEntity;

import java.util.List;

public interface Repository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    boolean remove(String nickname, String password);

    UserEntity getUserEntityByNickNameAndPassword(String nickname, String password);

    boolean logOut(Long userId);

    boolean logIn(Long userId);

    UserEntity getUserById(Long userId);

    UserEntity getUserByNickName(String nickname);

    UserEntity getUserByMail(String mail);

    boolean verifyUserByNickname(String nickname);

    boolean verifyUserByPassword(String password);
}
