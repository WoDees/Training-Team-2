package com.trainingApplication.core.validation.quiz;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.QuizRequest;
import org.springframework.stereotype.Component;

@Component
public class QuizFormatValidationRule implements QuizValidationRule {

    @Override
    public void validate(QuizRequest request) {
        if (request.getGender() == null) {
            throw new ValidationException("Gender must not be null.");
        }
        if (request.getAge() == null) {
            throw new ValidationException("Age must not be null.");
        }
        if (request.getWeight() == null) {
            throw new ValidationException("Weight must not be null.");
        }
        if (request.getGrowth() == null) {
            throw new ValidationException("Growth must not be null.");
        }
        if (request.getDesiredWeight() == null) {
            throw new ValidationException("Desired weight must not be null.");
        }
        if (request.getTarget() == null) {
            throw new ValidationException("Target must not be null.");
        }
    }
}
