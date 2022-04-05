package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.remove.RemoveValidationService;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.RemoveUserRequest;
import com.trainingApplication.dto.response.RemoveUserResponse;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Service;

@Service
public class RemoveUserService {

    private final Repository repository;
    private final RemoveValidationService removeValidationService;

    public RemoveUserService(Repository repository, RemoveValidationService removeValidationService) {
        this.repository = repository;
        this.removeValidationService = removeValidationService;
    }

    public RemoveUserResponse remove(RemoveUserRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = removeValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors:");
            validationResult.forEach(System.out::println);
            var response = new RemoveUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var removedEntity = repository.remove(entity.getNickname(), entity.getPassword());
        System.out.println("Remove successful: " + removedEntity);

        var response = new RemoveUserResponse();
        response.setRemovedAccount(removedEntity);
        System.out.println("Sending response: " + response);
        return response;
    }

    private UserEntity convert(RemoveUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickname(request.getNickname());
        entity.setPassword(request.getPassword());

        return entity;
    }
}
