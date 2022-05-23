package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.UserEntityDTO;
import com.trainingApplication.dto.response.FindByIdUserResponse;
import com.trainingApplication.repository.user.HibernateUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserByIdService {

    private final HibernateUserRepository repository;


    public FindByIdUserResponse getById(Long id) {
        return repository.getUserById(id)
                .map(this::convert)
                .map(FindByIdUserResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("Training Day with id " + id + " is not found."));
    }

    private UserEntityDTO convert(UserEntity entity) {
        return new UserEntityDTO(entity.getId(), entity.getNickname(), entity.getPassword(), entity.getMail(), entity.isOnlineStatus(), entity.getTrainingDaysCount(), entity.getTrainingDaysEntities());
    }
}
