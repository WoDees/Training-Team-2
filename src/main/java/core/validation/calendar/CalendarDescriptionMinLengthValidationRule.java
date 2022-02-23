package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

public class CalendarDescriptionMinLengthValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        checkNotNull(entity);
        if (entity.getDescription().length() < 5) {
            throw new ValidationException("Calendar description length must be more than 5 but actual description length is "
                    + entity.getDescription().length());
        }
    }
}
