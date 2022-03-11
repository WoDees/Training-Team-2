package com.trainingApplication.core.validation.calendar;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarDescriptionLengthValidationRuleTest {

    CalendarDescriptionLengthValidationRule validationRule = new CalendarDescriptionLengthValidationRule();

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrect() {
        var request = new AddCalendarRequest();
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrectSecondTest() {
        var request = new AddCalendarRequest();
        request.setDescription("Test");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrectThirdTest() {
        var request = new AddCalendarRequest();
        request.setDescription("Testdasdhsafdahfsdhfsdfyshhysdhfudsfjudsjfsudfjsdufadsadasd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException() {
        var request = new AddCalendarRequest();
        request.setDescription("Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionSecondTest() {
        var request = new AddCalendarRequest();
        request.setDescription("Test_Description, Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionThirdTest() {
        var request = new AddCalendarRequest();
        request.setDescription("Test_Description,Test_Description,Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }
}