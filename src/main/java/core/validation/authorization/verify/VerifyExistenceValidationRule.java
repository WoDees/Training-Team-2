package core.validation.authorization.verify;

import core.validation.ValidationException;
import dto.request.VerifyUserRequest;
import repository.Repository;

public class VerifyExistenceValidationRule implements VerifyValidationRule {

    private final Repository repository;

    public VerifyExistenceValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(VerifyUserRequest request) {
        if (!repository.verifyUserByNickname(request.getNickname())) {
            throw new ValidationException("User does not exist!");
        }
        if (request.getNickname().equals(repository.getUserByNickName(request.getNickname()).getNickname()) &&
                !request.getPassword().equals(repository.getUserByNickName(request.getNickname()).getPassword())) {
            throw new ValidationException("Incorrect password");
        }
    }
}
