package repository;

import domain.UserEntity;

import java.util.List;

public interface Repository {

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    boolean verify(String nickName, String password);

    boolean remove(String login, String password);

    UserEntity getUserEntity(String nickName, String password);

}
