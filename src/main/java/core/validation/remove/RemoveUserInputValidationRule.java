package core.validation.remove;

import core.validation.ValidationException;
import dto.request.RemoveUserRequest;

public class RemoveUserInputValidationRule implements RemoveValidationRule {

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
