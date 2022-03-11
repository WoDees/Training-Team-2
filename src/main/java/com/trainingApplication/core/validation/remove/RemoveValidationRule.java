package com.trainingApplication.core.validation.remove;

import com.trainingApplication.dto.request.RemoveUserRequest;

public interface RemoveValidationRule {

    void validate(RemoveUserRequest request);
}
