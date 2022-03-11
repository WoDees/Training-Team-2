package com.javaguru.core.service;

import com.trainingApplication.core.service.RemoveUserService;
import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.remove.RemoveValidationService;
import com.trainingApplication.dto.response.RemoveUserResponse;
import com.trainingApplication.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static com.javaguru.core.service.TestDtoFactory.createRemoveUserRequest;

@ExtendWith(MockitoExtension.class)
class RemoveUserServiceTest {

    @Mock
    private Repository repository;

    @Mock
    private RemoveValidationService validationService;

    @InjectMocks
    private RemoveUserService removeUserService;


    @Test
    void shouldRemoveUser() {
        var request = createRemoveUserRequest();
        when(validationService.validate(request)).thenReturn(List.of());
        when(repository.remove(request.getNickname(), request.getPassword())).thenReturn(true);

        var result = removeUserService.remove(request);

        verify(repository).remove(any(), any());
        verify(validationService).validate(any());

        var expected = new RemoveUserResponse();
        expected.setRemovedAccount(true);
        expected.setErrors(null);

        assertEquals(expected, result);
    }

    @Test
    void shouldNotRemoveUser() {
        var request = createRemoveUserRequest();
        when(validationService.validate(request)).thenReturn(List.of(new CoreError("TEST_ERROR")));

        var result = removeUserService.remove(request);

        verify(validationService).validate(any());
        verifyNoInteractions(repository);

        var expected = new RemoveUserResponse();
        expected.setErrors(List.of(new CoreError("TEST_ERROR")));
        expected.setRemovedAccount(false);

        assertEquals(expected, result);
    }
}