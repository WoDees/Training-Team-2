package com.trainingApplication.repository.user;

import com.trainingApplication.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    boolean remove(Long id);

    UserEntity getUserEntityByNickNameAndPassword(String nickname, String password);

    boolean logOut(Long userId);

    boolean logIn(Long userId);

    Optional<UserEntity> getUserById(Long userId);

    UserEntity getUserByNickName(String nickname);

    UserEntity getUserByMail(String mail);

    boolean verifyUserByNickname(String nickname);

    boolean verifyUserByPassword(String password);

    boolean existsUserByMail(String mail);

    boolean existsUserByNickname(String nickname);
}
