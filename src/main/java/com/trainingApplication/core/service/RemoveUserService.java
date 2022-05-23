package com.trainingApplication.core.service;

import com.trainingApplication.dto.response.RemoveUserResponse;
import com.trainingApplication.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RemoveUserService {

    private final UserRepository repository;

    public RemoveUserResponse remove(Long id) {
        System.out.println("Received request: " + id);

        var removedEntity = repository.remove(id);

        if (removedEntity) {
            System.out.println("Remove successful: " + removedEntity);
        }

        var response = new RemoveUserResponse();
        response.setRemovedAccount(removedEntity);
        System.out.println("Sending response: " + response);
        return response;
    }

}
