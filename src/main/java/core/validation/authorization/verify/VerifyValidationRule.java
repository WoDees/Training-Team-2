package core.validation.authorization.verify;

import dto.request.VerifyUserRequest;

public interface VerifyValidationRule {

    void validate(VerifyUserRequest request);

}
