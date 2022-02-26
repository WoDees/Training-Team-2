package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import dto.AddCalendarRequest;

public class CalendarDateFormatValidationRule implements CalendarValidationRule {

    @Override
    public void validate(AddCalendarRequest request) {
        if (request.getEventDate() == null) {
            throw new ValidationException("Calendar number must not be null.");
        }
        if (!request.getEventDate().matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
            throw new ValidationException("Calendar name not correct, should be (dd/mm/yyyy) ");
        }
    }
}
