package core.validation;

import domain.CalendarEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalendarValidationService {

    private final List<CalendarValidationRule> calendarValidationRules;

    public CalendarValidationService(List<CalendarValidationRule> calendarValidationRules) {
        this.calendarValidationRules = calendarValidationRules;
    }

    public List<CoreError> validate(CalendarEntity entity) {
        List<CoreError> errors = new ArrayList<>();
        if (entity == null) {
            errors.add(new CoreError("Date must not be null"));
            return errors;
        }

        return calendarValidationRules.stream()
                .map(rule -> mapError(rule, entity))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(CalendarValidationRule rule, CalendarEntity entity) {
        try {
            rule.validate(entity);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
