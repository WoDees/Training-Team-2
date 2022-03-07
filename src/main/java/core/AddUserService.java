package core;

import core.validation.authorization.registration.RegistrationValidationService;
import domain.UserEntity;
import dto.request.AddUserRequest;
import dto.response.AddUserResponse;
import repository.Repository;

import java.util.List;

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
        response.setCreatedUserId(createdEntity.getUserId());
        response.setOnlineStatus(true);
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

    public List<UserEntity> findAll(){
        return repository.findAll();
    }
}
