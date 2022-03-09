package test_factory;

import domain.UserEntity;
import dto.request.AddUserRequest;

public class TestDtoFactory {

    public static AddUserRequest createRequest() {
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
}
