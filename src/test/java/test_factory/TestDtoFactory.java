package test_factory;

import domain.UserEntity;
import dto.request.AddUserRequest;
import dto.request.LogOutUserRequest;

public class TestDtoFactory {

    public static AddUserRequest createAddUserRequest() {
        var request = new AddUserRequest();
        request.setNickname("TEST_NICKNAME");
        request.setPassword("TEST_PASSWORD");
        request.setMail("TEST_MAIL");
        return request;
    }

    public static UserEntity createEntity(Long userId) {
        var entity = new UserEntity();
        entity.setUserId(userId);
        entity.setNickname("TEST_NICKNAME");
        entity.setPassword("TEST_PASSWORD");
        entity.setMail("TEST_MAIL");
        entity.setOnlineStatus(true);
        return entity;
    }

    public static LogOutUserRequest createLogOutRequest(Long userId) {
        var request = new LogOutUserRequest();
        request.setOnlineStatus(false);
        request.setUserId(userId);
        return request;
    }
}
