package core.validation.authorization.registration;

import core.validation.CoreError;
import core.validation.ValidationException;
import dto.request.AddUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static test_factory.TestDtoFactory.createAddUserRequest;

@ExtendWith(MockitoExtension.class)
class RegistrationValidationServiceTest {

    @Mock
    private RegistrationValidationRule validationRule;

    @Captor
    private ArgumentCaptor<AddUserRequest> addUserRequestArgumentCaptor;

    private RegistrationValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new RegistrationValidationService(List.of(validationRule));
    }

    @Test
    void shouldValidateErrors() {
        doThrow(new ValidationException("TEST_EXCEPTION")).when(validationRule).validate(any());
        var request = new AddUserRequest();
        request.setNickname("TEST_NICKNAME");
        var actual = validationService.validate(request);

        verify(validationRule).validate(addUserRequestArgumentCaptor.capture());
        var captureRequest = addUserRequestArgumentCaptor.getValue();

        assertNotNull(captureRequest);
        assertEquals("TEST_NICKNAME", captureRequest.getNickname());

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("TEST_EXCEPTION"));
    }

    @Test
    void shouldValidateWithoutErrors() {
        var request = createAddUserRequest();

        var actual = validationService.validate(request);

        verify(validationRule).validate(addUserRequestArgumentCaptor.capture());
        var captureRequest = addUserRequestArgumentCaptor.getValue();

        System.out.println(captureRequest);

        assertEquals(actual, List.of());
        assertEquals(captureRequest, request);

    }
}