package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.LogOutUserRequest;
import com.trainingApplication.dto.response.LogOutUserResponse;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Service;

@Service
public class LogOutUserService {

    private final Repository repository;

    public LogOutUserService(Repository repository) {
        this.repository = repository;
    }

    public LogOutUserResponse logOut(LogOutUserRequest request) {
        System.out.println("Received request: " + request);
        var entity = convert(request);
        var logOutEntity = repository.logOut(entity.getId());
        System.out.println("Log out successful:");

        var response = new LogOutUserResponse();
        response.setUserId(entity.getId());
        response.setOnlineStatus(!logOutEntity);
        System.out.println("Sending response: " + response);
        return response;

    }

    private UserEntity convert(LogOutUserRequest request) {
        var entity = new UserEntity();
        entity.setOnlineStatus(request.isOnlineStatus());
        entity.setId(request.getUserId());

        return entity;
    }
}
