package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import domain.CalendarEntity;

import java.util.regex.Pattern;

public class CalendarCorrectDateFormatValidationRule implements CalendarValidationRule {

    @Override
    public void validate(CalendarEntity entity) {
        checkNotNull(entity);
        String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

        if (!Pattern.matches(regex, entity.getEventDate())) {
            throw new ValidationException("Calendar name not correct, should be (dd/MM/yyyy) ");
        }
    }
}
