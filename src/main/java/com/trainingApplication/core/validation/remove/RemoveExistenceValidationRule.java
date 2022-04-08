package com.trainingApplication.core.validation.remove;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.RemoveUserRequest;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Component;

@Component
public class RemoveExistenceValidationRule implements RemoveValidationRule {

    private final Repository repository;

    public RemoveExistenceValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(RemoveUserRequest request) {
        if (!repository.verifyUserByNickname(request.getNickname())) {
            throw new ValidationException("User does not exist!");
        }
        if (repository.existsUserByNickname(request.getNickname()) &&
                !repository.verifyUserByPassword(request.getPassword())) {
            throw new ValidationException("Incorrect password");
        }
    }
}
