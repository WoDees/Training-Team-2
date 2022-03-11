package com.trainingApplication.core.validation.authorization.registration;

import com.trainingApplication.dto.request.AddUserRequest;

public interface RegistrationValidationRule {

    void validate(AddUserRequest request);

}
