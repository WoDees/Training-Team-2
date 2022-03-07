package core.validation;

import dto.request.AddCalendarRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CalendarValidationService {

    private final List<CalendarValidationRule> calendarValidationRules;

    public CalendarValidationService(List<CalendarValidationRule> calendarValidationRules) {
        this.calendarValidationRules = calendarValidationRules;
    }

    public List<CoreError> validate(AddCalendarRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Date must not be null"));
            return errors;
        }

        return calendarValidationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(CalendarValidationRule rule, AddCalendarRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
