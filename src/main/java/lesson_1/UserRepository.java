package lesson_1;

import domain.UserEntity;

import java.util.LinkedList;
import java.util.List;

class UserRepository implements Repository {

    private final List<UserEntity> userEntityList = new LinkedList<>();
    private int sequence = 0;

    @Override
    public int save(UserEntity userEntity) {
        userEntity.setUserId(++sequence);
        userEntityList.add(userEntity);
        return userEntity.getUserId();
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        return userEntityList.remove(userEntity);
    }

    @Override
    public boolean updatePassword(UserEntity userEntity, String newPassword) {
        if (userEntityList.contains(userEntity)) {
            userEntityList.get(userEntity.getUserId()).setPassword(newPassword);
            return true;
        }
        return false;
    }

    public List<UserEntity> getUserList() {
        return userEntityList;
    }
}
