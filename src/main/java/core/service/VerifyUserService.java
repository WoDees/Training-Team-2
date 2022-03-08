package core.service;

import core.validation.authorization.verify.VerifyValidationService;
import domain.UserEntity;
import dto.request.VerifyUserRequest;
import dto.response.VerifyUserResponse;
import repository.Repository;

import java.util.List;

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
        System.out.println("Log in successful: " + verifiedEntity);

        var response = new VerifyUserResponse();
        response.setUserId(verifiedEntity.getUserId());
        response.setOnlineStatus(true);
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
