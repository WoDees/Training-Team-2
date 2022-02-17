package repository;

import domain.UserEntity;

import java.util.List;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    boolean verify(String nickName, String password);

}
