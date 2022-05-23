package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.UserEntityDTO;
import com.trainingApplication.dto.response.FindAllUserResponse;
import com.trainingApplication.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FindAllUserService {

    private final UserRepository repository;

    public FindAllUserService(UserRepository repository) {
        this.repository = repository;
    }

    public FindAllUserResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return new FindAllUserResponse(dtos);
    }

    private UserEntityDTO convert(UserEntity entity) {
        return new UserEntityDTO(entity.getId(), entity.getNickname(), entity.getPassword(), entity.getMail(), entity.isOnlineStatus(), entity.getTrainingDaysCount(), entity.getTrainingDaysEntities());
    }
}
