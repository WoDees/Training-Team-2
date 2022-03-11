package com.javaguru.core.service;

import com.trainingApplication.core.service.AddUserService;
import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.authorization.registration.RegistrationValidationService;
import com.trainingApplication.dto.response.AddUserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.Repository;

import java.util.List;

import static com.javaguru.core.service.TestDtoFactory.createAddUserRequest;
import static com.javaguru.core.service.TestDtoFactory.createEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

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
        var request = createAddUserRequest();
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
        var request = createAddUserRequest();
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