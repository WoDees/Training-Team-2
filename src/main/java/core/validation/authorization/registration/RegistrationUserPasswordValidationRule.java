package core.validation.authorization.registration;

import core.validation.ValidationException;
import dto.request.AddUserRequest;

public class RegistrationUserPasswordValidationRule implements RegistrationValidationRule {

    @Override
    public void validate(AddUserRequest request) {
        if (!request.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,14}")) {
            throw new ValidationException("Password has to contain at least one capital letter, one small letter, one digit with the minimal length of 6");
        }
    }
}
