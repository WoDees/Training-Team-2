package com.trainingApplication.core.validation.authorization.registration;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUserNickNameValidationRule implements RegistrationValidationRule {

    private final Repository repository;

    public RegistrationUserNickNameValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(AddUserRequest request) {
        if (request.getNickname().length() < 5) {
            throw new ValidationException("User nick name length must be greater than 5, but actual nick name length is "
                    + request.getNickname().length());
        }
        if (request.getNickname().length() > 12) {
            throw new ValidationException("User nick name length must be less than 12, but actual nick name length is "
                    + request.getNickname().length());
        }
        if (!request.getNickname().matches("^[a-zA-Z0-9]+$")) {
            throw new ValidationException("User nick name can only contain available symbols (a-z A-Z 0-9)");
        }
        if (repository.getUserByNickName(request.getNickname()) != null) {
            if (repository.getUserByNickName(request.getNickname()).getNickname().equals(request.getNickname()))
                throw new ValidationException("User with that nick name already exist!");
        }
    }
}
