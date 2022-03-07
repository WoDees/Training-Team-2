package core;

import core.validation.ValidationService;
import domain.UserEntity;
import dto.request.AddUserRequest;
import dto.response.AddUserResponse;
import repository.Repository;

import java.util.Arrays;

public class AddUserService {

    private final Repository repository;
    private final ValidationService validationService;

    public AddUserService(Repository repository,
                          ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddUserResponse add(AddUserRequest request) {
        System.out.println("Received request: " + request);
        var entity = convert(request);
        var validationResult = validationService.validate(entity);

        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors:");
            validationResult.forEach(System.out::println);
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddUserResponse();
        response.setCreatedUserId(createdEntity.getUserId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private UserEntity convert(AddUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickName(request.getNickName());
        entity.setMail(request.getMail());
        entity.setPassword(request.getPassword());
        entity.setOnlineStatus(request.isOnlineStatus());

        return entity;
    }
}
