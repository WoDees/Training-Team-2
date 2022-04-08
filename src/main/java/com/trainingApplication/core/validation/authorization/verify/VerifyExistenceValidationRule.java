package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.VerifyUserRequest;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Component;

@Component
public class VerifyExistenceValidationRule implements VerifyValidationRule {

    private final Repository repository;

    public VerifyExistenceValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(VerifyUserRequest request) {
        if (!repository.verifyUserByNickname(request.getNickname())) {
            throw new ValidationException("User does not exist!");
        }
        if (repository.existsUserByNickname(request.getNickname()) &&
                !repository.verifyUserByPassword(request.getPassword())) {
            throw new ValidationException("Incorrect password");
        }
    }
}
