package com.trainingApplication.core.validation.calendar;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddCalendarRequest;

public interface CalendarValidationRule {

    void validate(AddCalendarRequest request);

    default void checkNotNull(AddCalendarRequest request) {
        if (request == null) {
            throw new ValidationException("Calendar date must not be null.");
        }
    }
}
