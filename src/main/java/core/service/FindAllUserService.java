package core.service;

import domain.UserEntity;
import dto.UserEntityDTO;
import dto.response.FindAllUserResponse;
import repository.Repository;

public class FindAllUserService {

    private final Repository repository;

    public FindAllUserService(Repository repository) {
        this.repository = repository;
    }

    public FindAllUserResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .toList();
        return new FindAllUserResponse(dtos);
    }

    private UserEntityDTO convert(UserEntity entity) {
        return new UserEntityDTO(entity.getUserId(), entity.getNickname(), entity.getPassword(), entity.getMail(), entity.isOnlineStatus());
    }
}
