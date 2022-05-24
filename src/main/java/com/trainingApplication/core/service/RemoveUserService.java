package com.trainingApplication.core.service;

import com.trainingApplication.dto.response.RemoveUserResponse;
import com.trainingApplication.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RemoveUserService {

    private final UserRepository repository;

    public RemoveUserResponse remove(Long id) {
        log.info("Received request: {}", id);

        var removedEntity = repository.remove(id);

        if (removedEntity) {
            log.debug("Remove successful: {}", removedEntity);
        } else {
            log.error("Remove unsuccessful: {}", removedEntity);
        }

        var response = new RemoveUserResponse();
        response.setRemovedAccount(removedEntity);
        log.debug("Sending response: {}", response);
        return response;
    }

}
