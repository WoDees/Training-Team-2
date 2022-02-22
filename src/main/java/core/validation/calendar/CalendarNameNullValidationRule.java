package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarNameNullValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        checkNotNull(entity);
        if (entity.getEventDate() == null) {
            throw new ValidationException("Calendar number must not be null.");
        }
    }
}
