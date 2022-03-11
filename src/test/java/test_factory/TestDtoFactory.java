package test_factory;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.request.LogOutUserRequest;
import com.trainingApplication.dto.request.RemoveUserRequest;
import com.trainingApplication.dto.request.VerifyUserRequest;

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

    public static RemoveUserRequest createRemoveUserRequest() {
        var request = new RemoveUserRequest();
        request.setNickname("TEST_NICKNAME");
        request.setPassword("TEST_PASSWORD");
        return request;
    }

    public static VerifyUserRequest createVerifyUserRequest() {
        var request = new VerifyUserRequest();
        request.setNickname("TEST_NICKNAME");
        request.setPassword("TEST_PASSWORD");
        return request;
    }
}
