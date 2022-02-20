package core.validation;

import domain.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(UserEntity toDoEntity) {
        List<CoreError> errors = new ArrayList<>();
        if (toDoEntity == null) {
            errors.add(new CoreError("ToDo must not be null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> mapError(rule, toDoEntity))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidationRule rule, UserEntity entity) {
        try {
            rule.validate(entity);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
