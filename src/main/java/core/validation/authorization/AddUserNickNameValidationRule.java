package core.validation.authorization;

import core.validation.ValidationException;
import core.validation.ValidationRule;
import dto.request.AddUserRequest;
import repository.Repository;

public class AddUserNickNameValidationRule implements ValidationRule {

    private final Repository repository;

    public AddUserNickNameValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(AddUserRequest request) {
        if (request.getNickName().length() < 5) {
            throw new ValidationException("User nick name length must be greater than 5, but actual nick name length is "
                    + request.getNickName().length());
        }
        if (request.getNickName().length() > 12) {
            throw new ValidationException("User nick name length must be less than 12, but actual nick name length is "
                    + request.getNickName().length());
        }
        if (!request.getNickName().matches("^[a-zA-Z0-9]+$")) {
            throw new ValidationException("User nick name can only contain available symbols (a-z A-Z 0-9)");
        }
        if (repository.getUserByNickName(request.getNickName()) != null) {
            if (repository.getUserByNickName(request.getNickName()).getNickName().equals(request.getNickName()))
                throw new ValidationException("User with that nick name already exist!");
        }
    }
}
