package core;

import core.validation.ValidationService;
import domain.UserEntity;
import dto.request.VerifyUserRequest;
import dto.response.VerifyUserResponse;
import repository.Repository;

import java.util.List;

public class VerifyUserService {

    private final Repository repository;

    public VerifyUserService(Repository repository) {
        this.repository = repository;
    }

    public VerifyUserResponse entrance(VerifyUserRequest request) {
        var entity = convert(request);

        boolean verifiedEntity = repository.verify(entity.getNickName(), entity.getPassword());

        var response = new VerifyUserResponse();
        response.setUserId(repository.getUserByNickName(entity.getNickName()).getUserId());
        response.setOnlineStatus(verifiedEntity);

        return response;

    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    private UserEntity convert(VerifyUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setNickName(request.getNickName());
        entity.setPassword(request.getPassword());
        entity.setOnlineStatus(request.isOnlineStatus());

        return entity;
    }
}
