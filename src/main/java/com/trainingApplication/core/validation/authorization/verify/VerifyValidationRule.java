package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.dto.request.VerifyUserRequest;

public interface VerifyValidationRule {

    void validate(VerifyUserRequest request);

}
