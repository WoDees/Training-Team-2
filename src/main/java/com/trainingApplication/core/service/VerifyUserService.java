package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.authorization.verify.VerifyValidationService;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.VerifyUserRequest;
import com.trainingApplication.dto.response.VerifyUserResponse;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VerifyUserService {

    private final Repository repository;
    private final VerifyValidationService verifyValidationService;

    public VerifyUserService(Repository repository, VerifyValidationService verifyValidationService) {
        this.repository = repository;
        this.verifyValidationService = verifyValidationService;
    }

    public VerifyUserResponse entrance(VerifyUserRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = verifyValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors:");
            validationResult.forEach(System.out::println);
            var response = new VerifyUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var verifiedEntity = repository.getUserEntityByNickNameAndPassword(entity.getNickname(), entity.getPassword());
        repository.logIn(verifiedEntity.getUserId());
        System.out.println("Log in successful: " + verifiedEntity);

        var response = new VerifyUserResponse();
        response.setUserId(verifiedEntity.getUserId());
        response.setOnlineStatus(verifiedEntity.isOnlineStatus());
        System.out.println("Sending response: " + response);
        return response;
    }

    private UserEntity convert(VerifyUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickname(request.getNickname());
        entity.setPassword(request.getPassword());

        return entity;
    }
}
