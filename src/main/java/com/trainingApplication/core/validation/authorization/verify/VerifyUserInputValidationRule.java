package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.VerifyUserRequest;
import com.trainingApplication.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class VerifyUserInputValidationRule implements VerifyValidationRule {

    private final Repository repository;

    public VerifyUserInputValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(VerifyUserRequest request) {
        if (request.getNickname().equals("") || request.getPassword().equals("")) {
            throw new ValidationException("The field cannot be empty");
        }
        if (!request.getNickname().matches("^[a-zA-Z0-9]+$")) {
            throw new ValidationException("User nick name can only contain available symbols (a-z A-Z 0-9)");
        }
        if (!request.getPassword().matches("^[a-zA-Z0-9]+$")) {
            throw new ValidationException("User password can only contain available symbols (a-z A-Z 0-9)");
        }
    }
}
