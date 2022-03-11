package com.trainingApplication.core.validation.authorization.verify;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.VerifyUserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VerifyValidationService {

    private final List<VerifyValidationRule> validationRules;

    public VerifyValidationService(List<VerifyValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(VerifyUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("User must not be null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(VerifyValidationRule rule, VerifyUserRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
