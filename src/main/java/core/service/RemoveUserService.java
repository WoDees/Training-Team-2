package core.service;

import core.validation.remove.RemoveValidationService;
import domain.UserEntity;
import dto.request.RemoveUserRequest;
import dto.response.RemoveUserResponse;
import repository.Repository;

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
