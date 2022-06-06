package com.trainingApplication.core.service;

import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.UserEntityDTO;
import com.trainingApplication.dto.response.FindAllUserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.user.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllUserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private FindAllUserService findAllUserService;

    @Test
    void shouldFindAllToDos() {
        var returnResult = entities();
        when(repository.findAll()).thenReturn(returnResult);

        var result = findAllUserService.findAll();
        var expectedResult = response();

        assertEquals(expectedResult, result);
    }

    private List<UserEntity> entities() {
        var returnEntity = new UserEntity();
        returnEntity.setId(1L);
        returnEntity.setNickname("TEST_NICKNAME");
        returnEntity.setPassword("TEST_PASSWORD");
        returnEntity.setMail("TEST_MAIL");
        returnEntity.setOnlineStatus(true);

        return List.of(returnEntity);
    }

    private FindAllUserResponse response() {
        var dto = new UserEntityDTO(1L, "TEST_NICKNAME", "TEST_PASSWORD", "TEST_MAIL", true, 1L, List.of());
        return new FindAllUserResponse((List.of(dto)));
    }
}