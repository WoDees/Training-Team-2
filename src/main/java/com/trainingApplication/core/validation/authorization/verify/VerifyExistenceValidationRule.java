package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.VerifyUserRequest;
import com.trainingApplication.repository.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class VerifyExistenceValidationRule implements VerifyValidationRule {

    private final UserRepository repository;

    public VerifyExistenceValidationRule(UserRepository repository) {
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
