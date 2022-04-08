package com.trainingApplication.core.validation.authorization.registration;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.repository.user.Repository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUserMailValidationRule implements RegistrationValidationRule {

    private final Repository repository;

    public RegistrationUserMailValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(AddUserRequest request) {
        if (!request.getMail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,3})$")) {
            throw new ValidationException("Incorrect mail");
        }
        if (repository.existsUserByMail(request.getMail())) {
            throw new ValidationException("User with that mail already exist!");
        }
    }
}
