package core;

import core.validation.ValidationService;
import domain.UserEntity;
import dto.request.AddUserRequest;
import dto.response.AddUserResponse;
import repository.Repository;

public class AddUserService {

    private final Repository repository;
    private final ValidationService validationService;

    public AddUserService(Repository repository,
                          ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddUserResponse add(AddUserRequest request) {
        var entity = convert(request);
        var validationResult = validationService.validate(entity);

        if (!validationResult.isEmpty()) {
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        var createdEntity = repository.save(entity);
        var response = new AddUserResponse();
        response.setCreatedUserId(createdEntity.getUserId());
        response.setOnlineStatus(createdEntity.isOnlineStatus());
        return response;
    }

    private UserEntity convert(AddUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickName(request.getNickName());
        entity.setMail(request.getMail());
        entity.setPassword(request.getPassword());
        entity.setOnlineStatus(true);

        return entity;
    }
}
