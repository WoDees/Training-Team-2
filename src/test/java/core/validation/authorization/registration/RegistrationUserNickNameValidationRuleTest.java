package core.validation.authorization.registration;

import core.validation.ValidationException;
import dto.request.AddUserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ArrayListUserRepository;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegistrationUserNickNameValidationRuleTest {

    @Mock
    private Repository repository = new ArrayListUserRepository();

    RegistrationUserNickNameValidationRule validationRule = new RegistrationUserNickNameValidationRule(repository);

    @Test
    void shouldNotThrowException_1() {
        var request = new AddUserRequest();
        request.setNickname("nickname");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_2() {
        var request = new AddUserRequest();
        request.setNickname("ni22ckname");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldNotThrowException_3() {
        var request = new AddUserRequest();
        request.setNickname("222222");
        assertDoesNotThrow(() -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_1() {
        var request = new AddUserRequest();
        request.setNickname("");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_2() {
        var request = new AddUserRequest();
        request.setNickname("1");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_3() {
        var request = new AddUserRequest();
        request.setNickname("1111111111111111111");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_4() {
        var request = new AddUserRequest();
        request.setNickname("nicname!");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_5() {
        var request = new AddUserRequest();
        request.setNickname("фывффыв");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void shouldThrowException_6() {
        var request = new AddUserRequest();
        request.setNickname("!@#$%^&*");
        assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }
}