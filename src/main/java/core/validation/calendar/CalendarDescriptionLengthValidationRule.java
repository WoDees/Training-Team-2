package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarDescriptionLengthValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        if (entity.getDescription() == null) {
            throw new ValidationException("Calendar description must not be null.");
        }
        if (entity.getDescription().length() > 50) {
            throw new ValidationException("Calendar description length must be less than 50 but actual description length is "
                    + entity.getDescription().length());
        }
        if (entity.getDescription().length() < 5) {
            throw new ValidationException("Calendar description length must be more than 5 but actual description length is "
                    + entity.getDescription().length());
        }
    }
}
