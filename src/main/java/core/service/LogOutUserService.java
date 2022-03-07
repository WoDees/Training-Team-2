package core.service;

import domain.UserEntity;
import dto.request.LogOutUserRequest;
import dto.response.LogOutUserResponse;
import dto.response.VerifyUserResponse;
import repository.Repository;

import java.util.List;

public class LogOutUserService {

    private final Repository repository;

    public LogOutUserService(Repository repository) {
        this.repository = repository;
    }

    public LogOutUserResponse logOut(LogOutUserRequest request) {
        System.out.println("Received request: " + request);
        var entity = convert(request);
        var logOutEntity = repository.logOut(entity.getUserId());
        System.out.println("Log out successful: " + !logOutEntity);

        var response = new LogOutUserResponse();
        response.setUserId(entity.getUserId());
        response.setOnlineStatus(logOutEntity);
        System.out.println("Sending response: " + response);
        return response;

    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    private UserEntity convert(LogOutUserRequest request) {
        var entity = new UserEntity();
        entity.setOnlineStatus(request.isOnlineStatus());
        entity.setUserId(request.getUserId());

        return entity;
    }
}
