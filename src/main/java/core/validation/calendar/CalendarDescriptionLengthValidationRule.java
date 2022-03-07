package core.validation.calendar;

import core.validation.CalendarValidationRule;
import core.validation.ValidationException;
import dto.request.AddCalendarRequest;

public class CalendarDescriptionLengthValidationRule implements CalendarValidationRule {

    @Override
    public void validate(AddCalendarRequest request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Calendar description must not be null.");
        }
        if (request.getDescription().length() > 50) {
            throw new ValidationException("Calendar description length must be less than 50 but actual description length is "
                    + request.getDescription().length());
        }
        if (request.getDescription().length() < 5) {
            throw new ValidationException("Calendar description length must be more than 5 but actual description length is "
                    + request.getDescription().length());
        }
    }
}
