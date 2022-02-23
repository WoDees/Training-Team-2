package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarDescriptionMaxLengthValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        checkNotNull(entity);
        if (entity.getDescription().length() > 50) {
            throw new ValidationException("Calendar description length must be less than 50 but actual description length is "
                    + entity.getDescription().length());
        }
    }
}
