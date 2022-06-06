package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.request.AddUserRequest;
import com.trainingApplication.dto.response.AddUserResponse;
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
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddUserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private AddUserService addUserService;

    @Test
    void shouldSuccessfullySaveUser() {
        var request = createAddUserRequest();
        when(repository.save(createEntity(null))).thenReturn(createEntity(31L));

        var result = addUserService.add(request);

        verify(repository).save(any());

        var expected = new AddUserResponse();
        expected.setErrors(null);
        expected.setCreatedUserId(31L);
        expected.setOnlineStatus(true);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnError() {
        var request = createAddUserRequest();

        var result = addUserService.add(request);

        verifyNoInteractions(repository);

        var expected = new AddUserResponse();
        expected.setErrors(List.of(new CoreError("TEST_ERROR")));
        expected.setCreatedUserId(null);
        expected.setOnlineStatus(false);

        assertEquals(expected, result);
    }

    public static AddUserRequest createAddUserRequest() {
        var request = new AddUserRequest();
        request.setNickname("TEST_NICKNAME");
        request.setPassword("TEST_PASSWORD");
        request.setMail("TEST_MAIL");
        return request;
    }

    public static UserEntity createEntity(Long userId) {
        var entity = new UserEntity();
        entity.setId(userId);
        entity.setNickname("TEST_NICKNAME");
        entity.setPassword("TEST_PASSWORD");
        entity.setMail("TEST_MAIL");
        entity.setOnlineStatus(true);
        return entity;
    }
}