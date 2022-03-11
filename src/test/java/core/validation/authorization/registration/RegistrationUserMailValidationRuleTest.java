package core.validation.authorization.registration;

import core.validation.ValidationException;
import domain.UserEntity;
import dto.request.AddUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ArrayListUserRepository;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static test_factory.TestDtoFactory.createAddUserRequest;

@ExtendWith(MockitoExtension.class)
class RegistrationUserMailValidationRuleTest {

    @Mock
    private Repository repository = new ArrayListUserRepository();

    RegistrationUserMailValidationRule validationRule = new RegistrationUserMailValidationRule(repository);

    @Test
    void shouldNotThrowException_1() {
        var request = new AddUserRequest();
        request.setMail("mail@mail.ru");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_2() {
        var request = new AddUserRequest();
        request.setMail("mail@mail.com");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_1() {
        var request = new AddUserRequest();
        request.setMail("asdasd.asd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_2() {
        var request = new AddUserRequest();
        request.setMail("asdasd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_3() {
        var request = new AddUserRequest();
        request.setMail("asdasd@asd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_4() {
        var request = new AddUserRequest();
        request.setMail("asdasd@asd.");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_5() {
        var request = new AddUserRequest();
        request.setMail("asd.asd@asd.");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_6() {
        var request = new AddUserRequest();
        request.setMail("asd.asd@asd.s");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_7() {
        var request = new AddUserRequest();
        request.setMail("...@asd.ss");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_8() {
        var request = new AddUserRequest();
        request.setMail("asd@@@asd.asd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_9() {
        var request = new AddUserRequest();
        request.setMail("");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_10() {
        var request = new AddUserRequest();
        request.setMail("a@a.aa");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_11() {
        var request = new AddUserRequest();
        request.setMail("@.");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_12() {
        var request = new AddUserRequest();
        request.setMail("asd@.");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_13() {
        var request = new AddUserRequest();
        request.setMail("asd@sdd.sasddd");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }
}