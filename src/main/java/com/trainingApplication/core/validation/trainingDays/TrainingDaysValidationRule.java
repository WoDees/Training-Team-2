package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;

public interface TrainingDaysValidationRule {

    void validate(AddTrainingDaysRequest request);

    default void checkNotNull(AddTrainingDaysRequest request) {
        if (request == null) {
            throw new ValidationException("Calendar date must not be null.");
        }
    }
}
