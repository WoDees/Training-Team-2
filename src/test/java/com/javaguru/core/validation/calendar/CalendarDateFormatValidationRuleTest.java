package com.javaguru.core.validation.calendar;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.core.validation.calendar.CalendarDateFormatValidationRule;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarDateFormatValidationRuleTest {

    CalendarDateFormatValidationRule validationRule = new CalendarDateFormatValidationRule();

    @Test
    void shouldThrowExceptionWhenDateIsIncorrect() {
        var request = new AddCalendarRequest();
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectSecondTest() {
        var request = new AddCalendarRequest();
        request.setEventDate("07/03/20000");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectThirdTest() {
        var request = new AddCalendarRequest();
        request.setEventDate("32/03/2022");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectFourthTest() {
        var request = new AddCalendarRequest();
        request.setEventDate("31/13/2022");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException() {
        var request = new AddCalendarRequest();
        request.setEventDate("07/03/2022");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionSecondTest() {
        var request = new AddCalendarRequest();
        request.setEventDate("23/12/2055");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionThirdTest() {
        var request = new AddCalendarRequest();
        request.setEventDate("31/12/9999");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }
}