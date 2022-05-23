package com.trainingApplication.core.service;

import com.trainingApplication.dto.response.LogOutUserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.user.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static test_factory.TestDtoFactory.createLogOutRequest;

@ExtendWith(MockitoExtension.class)
class LogOutUserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private LogOutUserService logOutUserService;

    @Test
    void shouldLogOut() {

        var request = createLogOutRequest(0L);
        when(repository.logOut(0L)).thenReturn(false);

        var result = logOutUserService.logOut(request);

        verify(repository).logOut(any());

        var expected = new LogOutUserResponse();
        expected.setOnlineStatus(false);
        expected.setUserId(0L);

        assertEquals(expected, result);
    }
}