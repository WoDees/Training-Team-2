package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
import com.trainingApplication.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddUserService {

    private final UserRepository repository;

    public AddUserResponse add(AddUserRequest request) {
        log.info("Received request: {}", request);
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        log.info("Successfully saved: {}", createdEntity);
        var response = new AddUserResponse();
        response.setCreatedUserId(createdEntity.getId());
        response.setOnlineStatus(createdEntity.isOnlineStatus());
        log.debug("Sending response: {}", response);
        return response;
    }

    private UserEntity convert(AddUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickname(request.getNickname());
        entity.setMail(request.getMail());
        entity.setPassword(request.getPassword());
        entity.setOnlineStatus(true);

        return entity;
    }
}
