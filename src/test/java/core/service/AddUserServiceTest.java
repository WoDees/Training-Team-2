package core.service;

import core.validation.CoreError;
import core.validation.authorization.registration.RegistrationValidationService;
import dto.response.AddUserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static test_factory.TestDtoFactory.createEntity;
import static test_factory.TestDtoFactory.createRequest;

@ExtendWith(MockitoExtension.class)
class AddUserServiceTest {

    @Mock
    private Repository repository;

    @Mock
    private RegistrationValidationService validationService;

    @InjectMocks
    private AddUserService addUserService;

    @Test
    void shouldSuccessfullySaveUser() {
        var request = createRequest();
        when(validationService.validate(request)).thenReturn(List.of());
        when(repository.save(createEntity(null))).thenReturn(createEntity(31L));

        var result = addUserService.add(request);

        verify(repository).save(any());
        verify(validationService).validate(any());

        var expected = new AddUserResponse();
        expected.setErrors(null);
        expected.setCreatedUserId(31L);
        expected.setOnlineStatus(true);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnError() {
        var request = createRequest();
        when(validationService.validate(request)).thenReturn(List.of(new CoreError("TEST_ERROR")));

        var result = addUserService.add(request);

        verify(validationService).validate(any());
        verifyNoInteractions(repository);

        var expected = new AddUserResponse();
        expected.setErrors(List.of(new CoreError("TEST_ERROR")));
        expected.setCreatedUserId(null);
        expected.setOnlineStatus(false);

        assertEquals(expected, result);
    }
}