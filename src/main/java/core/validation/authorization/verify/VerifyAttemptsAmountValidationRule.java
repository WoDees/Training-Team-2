package core.validation.authorization.verify;

import core.validation.ValidationException;
import dto.request.VerifyUserRequest;
import repository.Repository;

public class VerifyAttemptsAmountValidationRule implements VerifyValidationRule {

    private final Repository repository;
    private int sequence;

    public VerifyAttemptsAmountValidationRule(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(VerifyUserRequest request) {

        if (repository.verifyUserByNickname(request.getNickname()) &&
                !repository.verifyUserByPassword(request.getPassword())) {
            sequence++;
            if (sequence == 3) {
                System.out.println("Too many login attempts, please try later");
                System.exit(0);
            }
            throw new ValidationException("Attemp " + sequence + "/3.");
        }
    }
}
