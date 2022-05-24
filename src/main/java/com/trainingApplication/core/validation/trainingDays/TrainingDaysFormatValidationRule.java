package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.springframework.stereotype.Component;

@Component
public class TrainingDaysFormatValidationRule implements TrainingDaysValidationRule {

    @Override
    public void validate(AddTrainingDaysRequest request) {
        if (request.getTrainingDate() == null) {
            throw new ValidationException("Calendar number must not be null.");
        }
        if (!request.getTrainingDate().matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
            throw new ValidationException("Calendar name not correct, should be (dd/mm/yyyy) ");
        }
    }
}
