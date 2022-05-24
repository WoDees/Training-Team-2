package com.trainingApplication.core.validation.quiz;

import com.trainingApplication.dto.request.AddQuizRequest;

public interface QuizValidationRule {

    void validate(AddQuizRequest request);
}
