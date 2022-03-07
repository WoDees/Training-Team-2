package core.validation.remove;

import core.validation.ValidationException;
import dto.request.RemoveUserRequest;
import repository.Repository;

public class RemoveUserInputValidationRule implements RemoveValidationRule {

    private final Repository repository;

    public RemoveUserInputValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(RemoveUserRequest request) {
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