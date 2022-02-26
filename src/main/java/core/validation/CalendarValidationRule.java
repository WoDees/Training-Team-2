package core.validation;

import dto.AddCalendarRequest;

public interface CalendarValidationRule {

    void validate(AddCalendarRequest request);

    default void checkNotNull(AddCalendarRequest request) {
        if (request == null) {
            throw new ValidationException("Calendar date must not be null.");
        }
    }
}
