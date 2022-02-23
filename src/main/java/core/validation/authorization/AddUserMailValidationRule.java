package core.validation.authorization;

import core.validation.ValidationException;
import core.validation.ValidationRule;
import domain.UserEntity;

public class AddUserMailValidationRule implements ValidationRule {

    @Override
    public void validate(UserEntity entity) {
        if (!entity.getMail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,3})$")) {
            throw new ValidationException("Incorrect mail");
        }
    }
}
