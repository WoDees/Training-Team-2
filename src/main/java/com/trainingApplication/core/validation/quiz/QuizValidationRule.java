package com.trainingApplication.core.validation.quiz;

import com.trainingApplication.dto.request.QuizRequest;

public interface QuizValidationRule {

    void validate(QuizRequest request);
}
