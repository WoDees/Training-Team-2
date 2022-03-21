package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingDaysFormatValidationRuleTest {

    TrainingDaysFormatValidationRule validationRule = new TrainingDaysFormatValidationRule();

    @Test
    void shouldThrowExceptionWhenDateIsIncorrect() {
        var request = new AddTrainingDaysRequest();
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectSecondTest() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("07/03/20000");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectThirdTest() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("32/03/2022");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDateIsIncorrectFourthTest() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("31/13/2022");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("07/03/2022");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionSecondTest() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("23/12/2055");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionThirdTest() {
        var request = new AddTrainingDaysRequest();
        request.setEventDate("31/12/9999");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }
}
