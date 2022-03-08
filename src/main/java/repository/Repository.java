package repository;

import domain.UserEntity;

import java.util.List;

public interface Repository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    boolean verify(String nickname, String password);

    boolean remove(String nickname, String password);

    UserEntity getUserEntityByNickNameAndPassword(String nickname, String password);

    boolean logOut(Long userId);

    void logIn(Long userId);

    UserEntity getUserById(Long userId);

    UserEntity getUserByNickName(String nickname);

    UserEntity getUserByMail(String mail);

    boolean verifyUserByNickname(String nickname);

    boolean verifyUserByPassword(String password);
}
