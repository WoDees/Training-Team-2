package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.authorization.registration.RegistrationValidationService;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
import com.trainingApplication.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.rmi.server.LogStream.log;

@Slf4j
@Service
public class AddUserService {

    private final UserRepository repository;
    private final RegistrationValidationService registrationValidationService;

    public AddUserService(UserRepository repository,
                          RegistrationValidationService validationService) {
        this.repository = repository;
        this.registrationValidationService = validationService;
    }

    public AddUserResponse add(AddUserRequest request) {
        log.info("Received request: {}", request);
        var validationResult = registrationValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            log.warn("Validation failed, errors: {}", validationResult);
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }
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
