package com.trainingApplication.core.validation.quiz;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddQuizRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuizValidationService {

    private final List<QuizValidationRule> quizValidationRules;

    public QuizValidationService(List<QuizValidationRule> quizValidationRules) {
        this.quizValidationRules = quizValidationRules;
    }

    public List<CoreError> validate(AddQuizRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Quiz must not be null"));
            return errors;
        }

        return quizValidationRules.stream()
                .map(rule -> validateError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validateError(QuizValidationRule rule, AddQuizRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
