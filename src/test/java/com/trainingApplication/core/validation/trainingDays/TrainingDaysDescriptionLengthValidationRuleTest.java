package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingDaysDescriptionLengthValidationRuleTest {

    TrainingDaysDescriptionLengthValidationRule validationRule = new TrainingDaysDescriptionLengthValidationRule();

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrect() {
        var request = new AddTrainingDaysRequest();
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrectSecondTest() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Test");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionLengthIsIncorrectThirdTest() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Testdasdhsafdahfsdhfsdfyshhysdhfudsfjudsjfsudfjsdufadsadasd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionSecondTest() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Test_Description, Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowExceptionThirdTest() {
        var request = new AddTrainingDaysRequest();
        request.setDescription("Test_Description,Test_Description,Test_Description");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }
}
