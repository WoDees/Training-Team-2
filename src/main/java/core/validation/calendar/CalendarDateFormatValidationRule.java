package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarDateFormatValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        if (entity.getEventDate() == null) {
            throw new ValidationException("Calendar number must not be null.");
        }
        if (!entity.getEventDate().matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
            throw new ValidationException("Calendar name not correct, should be (dd/mm/yyyy) ");
        }
    }
}
