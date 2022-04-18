package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.dto.request.AddTrainingDaysRequest;

public interface TrainingDaysValidationRule {

    void validate(AddTrainingDaysRequest request);
}
