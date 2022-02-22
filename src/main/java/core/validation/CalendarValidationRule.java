package core.validation;

import domain.CalendarEntity;

public interface CalendarValidationRule {

    void validate(CalendarEntity entity);

    default void checkNotNull(CalendarEntity entity) {
        if (entity == null) {
            throw new ValidationException("Calendar date must not be null.");
        }
    }
}
