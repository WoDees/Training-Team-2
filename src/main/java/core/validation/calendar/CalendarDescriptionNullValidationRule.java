package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarDescriptionNullValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        checkNotNull(entity);
        if (entity.getDescription() == null) {
            throw new ValidationException("Calendar description must not be null.");
        }
    }
}
