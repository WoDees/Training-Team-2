package com.trainingApplication.core.validation.remove;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.RemoveUserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RemoveValidationService {

    private final List<RemoveValidationRule> validationRules;

    public RemoveValidationService(List<RemoveValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(RemoveUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("User must not be null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> validateError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validateError(RemoveValidationRule rule, RemoveUserRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
