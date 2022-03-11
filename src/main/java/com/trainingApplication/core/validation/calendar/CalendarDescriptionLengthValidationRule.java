package com.trainingApplication.core.validation.calendar;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.springframework.stereotype.Component;

@Component
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
