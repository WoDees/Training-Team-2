package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.UserEntityDTO;
import com.trainingApplication.dto.response.FindAllUserResponse;
import com.trainingApplication.repository.user.HibernateUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindAllUserService {

    private final HibernateUserRepository repository;

    public FindAllUserResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .toList();
        return new FindAllUserResponse(dtos);
    }

    private UserEntityDTO convert(UserEntity entity) {
        return new UserEntityDTO(entity.getUserId(), entity.getNickname(), entity.getPassword(), entity.getMail(), entity.isOnlineStatus(), entity.getTrainingDaysCount());
    }
}
