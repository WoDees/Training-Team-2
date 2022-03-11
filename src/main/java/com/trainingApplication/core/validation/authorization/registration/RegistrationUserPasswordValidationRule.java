package com.trainingApplication.core.validation.authorization.registration;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class RegistrationUserPasswordValidationRule implements RegistrationValidationRule {

    @Override
    public void validate(AddUserRequest request) {
        if (!request.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,14}")) {
            throw new ValidationException("Password has to contain at least one capital letter, one small letter, one digit with the minimal length of 6");
        }
    }
}
