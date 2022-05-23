package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.authorization.verify.VerifyValidationService;
import com.trainingApplication.dto.response.VerifyUserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.user.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static test_factory.TestDtoFactory.createEntity;
import static test_factory.TestDtoFactory.createVerifyUserRequest;

@ExtendWith(MockitoExtension.class)
class VerifyUserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private VerifyValidationService verifyValidationService;

    @InjectMocks
    private VerifyUserService verifyUserService;

    @Test
    void shouldSuccessfullyVerifyUser() {
        var request = createVerifyUserRequest();

        when(verifyValidationService.validate(request)).thenReturn(List.of());
        when(repository.getUserEntityByNickNameAndPassword(request.getNickname(), request.getPassword())).thenReturn(createEntity(11L));

        var result = verifyUserService.entrance(request);

        verify(verifyValidationService).validate(any());
        verify(repository).getUserEntityByNickNameAndPassword(any(), any());

        var expected = new VerifyUserResponse();
        expected.setUserId(11L);
        expected.setOnlineStatus(true);
        expected.setErrors(null);

        assertEquals(expected, result);
    }

    @Test
    void shouldUnSuccessfullyVerifyUser() {
        var request = createVerifyUserRequest();

        when(verifyValidationService.validate(request)).thenReturn(List.of(new CoreError("TEST_ERROR")));

        var result = verifyUserService.entrance(request);


        verify(verifyValidationService).validate(any());
        verifyNoInteractions(repository);

        var expected = new VerifyUserResponse();
        expected.setUserId(null);
        expected.setOnlineStatus(false);
        expected.setErrors(List.of(new CoreError("TEST_ERROR")));

        assertEquals(expected, result);
    }
}