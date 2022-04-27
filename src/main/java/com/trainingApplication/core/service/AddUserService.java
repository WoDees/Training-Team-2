package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.authorization.registration.RegistrationValidationService;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {

    private final Repository repository;
    private final RegistrationValidationService registrationValidationService;

    public AddUserService(Repository repository,
                          RegistrationValidationService validationService) {
        this.repository = repository;
        this.registrationValidationService = validationService;
    }

    public AddUserResponse add(AddUserRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = registrationValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors:");
            validationResult.forEach(System.out::println);
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddUserResponse();
        response.setCreatedUserId(createdEntity.getId());
        response.setOnlineStatus(createdEntity.isOnlineStatus());
        System.out.println("Sending response: " + response);
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
