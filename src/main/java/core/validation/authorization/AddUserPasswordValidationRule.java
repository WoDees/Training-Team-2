package core.validation.authorization;

import core.validation.ValidationException;
import core.validation.ValidationRule;
import domain.UserEntity;

public class AddUserPasswordValidationRule implements ValidationRule {

    @Override
    public void validate(UserEntity entity) {
        if (!entity.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,14}")) {
            throw new ValidationException("Password has to contain at least one capital letter, one small letter, one digit with the minimal length of 6");
        }
    }
}
