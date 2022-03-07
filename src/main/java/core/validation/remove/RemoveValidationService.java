package core.validation.remove;

import core.validation.CoreError;
import core.validation.ValidationException;
import dto.request.RemoveUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(RemoveValidationRule rule, RemoveUserRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
