package com.trainingApplication.core.validation.calendar;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
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
                .map(rule -> validate(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validate(CalendarValidationRule rule, AddCalendarRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
