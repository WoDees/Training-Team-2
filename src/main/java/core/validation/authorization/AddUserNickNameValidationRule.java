package core.validation.authorization;

import core.validation.ValidationException;
import core.validation.ValidationRule;
import domain.UserEntity;
import repository.Repository;

public class AddUserNickNameValidationRule implements ValidationRule {

    private final Repository repository;

    public AddUserNickNameValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(UserEntity entity) {
        if (entity.getNickName().length() < 5) {
            throw new ValidationException("User nick name length must be greater than 5, but actual nick name length is "
                    + entity.getNickName().length());
        }
        if (entity.getNickName().length() > 12) {
            throw new ValidationException("User nick name length must be less than 12, but actual nick name length is "
                    + entity.getNickName().length());
        }
        if (!entity.getNickName().matches("^[a-zA-Z0-9]+$")) {
            throw new ValidationException("User nick name can only contain available symbols (a-z A-Z 0-9)");
        }
        if (repository.getUserByNickName(entity.getNickName()) != null) {
            if (repository.getUserByNickName(entity.getNickName()).getNickName().equals(entity.getNickName()))
                throw new ValidationException("User with that nick name already exist!");
        }
    }
}
