package com.trainingApplication.core.validation.authorization.registration;

import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.ArrayListUserRepository;
import com.trainingApplication.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationUserPasswordValidationRuleTest {

    RegistrationUserPasswordValidationRule validationRule = new RegistrationUserPasswordValidationRule();

    @Test
    void shouldNotThrowException_1() {
        var request = new AddUserRequest();
        request.setPassword("Asdddd2");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_2() {
        var request = new AddUserRequest();
        request.setPassword("As2dddd");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_3() {
        var request = new AddUserRequest();
        request.setPassword("AAAAaAAAA2");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_4() {
        var request = new AddUserRequest();
        request.setPassword("2323441aA");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_1() {
        var request = new AddUserRequest();
        request.setPassword("");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_2() {
        var request = new AddUserRequest();
        request.setPassword("Asd2asdasdasdsadsdsd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_3() {
        var request = new AddUserRequest();
        request.setPassword("A2s");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_4() {
        var request = new AddUserRequest();
        request.setPassword("aaaaa2");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_5() {
        var request = new AddUserRequest();
        request.setPassword("aaaaaa");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_6() {
        var request = new AddUserRequest();
        request.setPassword("aaaaaaA");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_7() {
        var request = new AddUserRequest();
        request.setPassword("AAAAAA");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_8() {
        var request = new AddUserRequest();
        request.setPassword("AAAAAAa");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_9() {
        var request = new AddUserRequest();
        request.setPassword("AAAAAA2");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_10() {
        var request = new AddUserRequest();
        request.setPassword("222222");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_11() {
        var request = new AddUserRequest();
        request.setPassword("222222a");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_12() {
        var request = new AddUserRequest();
        request.setPassword("222222A");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_13() {
        var request = new AddUserRequest();
        request.setPassword("Asdasd!2");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_14() {
        var request = new AddUserRequest();
        request.setPassword("asdasdA2@34");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }
}