package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TrainingDaysValidationService {

    private final List<TrainingDaysValidationRule> trainingDaysValidationRules;

    public TrainingDaysValidationService(List<TrainingDaysValidationRule> trainingDaysValidationRules) {
        this.trainingDaysValidationRules = trainingDaysValidationRules;
    }

    public List<CoreError> validate(AddTrainingDaysRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Date must not be null"));
            return errors;
        }

        return trainingDaysValidationRules.stream()
                .map(rule -> validate(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validate(TrainingDaysValidationRule rule, AddTrainingDaysRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
