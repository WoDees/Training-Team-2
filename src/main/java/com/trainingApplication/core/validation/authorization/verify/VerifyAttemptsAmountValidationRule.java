package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.VerifyUserRequest;
import com.trainingApplication.repository.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class VerifyAttemptsAmountValidationRule implements VerifyValidationRule {

    private final UserRepository repository;
    private int sequence;

    public VerifyAttemptsAmountValidationRule(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(VerifyUserRequest request) {

        if (repository.existsUserByNickname(request.getNickname()) &&
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
