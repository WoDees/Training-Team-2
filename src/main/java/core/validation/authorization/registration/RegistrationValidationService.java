package core.validation.authorization.registration;

import core.validation.CoreError;
import core.validation.ValidationException;
import dto.request.AddUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RegistrationValidationService {

    private final List<RegistrationValidationRule> validationRules;

    public RegistrationValidationService(List<RegistrationValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(AddUserRequest request) {
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

    private CoreError mapError(RegistrationValidationRule rule, AddUserRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}