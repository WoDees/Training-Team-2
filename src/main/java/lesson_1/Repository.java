package lesson_1;

import domain.UserEntity;

interface Repository {

    int save(UserEntity userEntity);

    boolean delete(UserEntity userEntity);

    boolean updatePassword(UserEntity userEntity, String newPassword);
}
