package core.validation.authorization;

import core.validation.ValidationException;
import core.validation.ValidationRule;
import dto.request.AddUserRequest;
import repository.Repository;

public class AddUserMailValidationRule implements ValidationRule {

    private final Repository repository;

    public AddUserMailValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(AddUserRequest request) {
        if (!request.getMail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,3})$")) {
            throw new ValidationException("Incorrect mail");
        }
        if (repository.getUserByMail(request.getMail()) != null) {
            if (repository.getUserByMail(request.getMail()).getMail().equals(request.getMail())) {
                throw new ValidationException("User with that mail already exist!");
            }
        }
    }
}
