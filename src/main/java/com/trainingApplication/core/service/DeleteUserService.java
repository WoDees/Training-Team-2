package com.trainingApplication.core.service;

import com.trainingApplication.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteUserService {

    private final UserRepository repository;

    public void remove(Long id) {
        log.info("Received for user deleting request : {}", id);

        repository.deleteById(id);
    }

}
