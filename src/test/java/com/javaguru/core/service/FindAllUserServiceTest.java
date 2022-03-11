package com.javaguru.core.service;

import com.trainingApplication.core.service.FindAllUserService;
import com.trainingApplication.domain.UserEntity;
import com.trainingApplication.dto.UserEntityDTO;
import com.trainingApplication.dto.response.FindAllUserResponse;
import com.trainingApplication.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllUserServiceTest {

    @Mock
    private Repository repository;

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
        returnEntity.setUserId(1L);
        returnEntity.setNickname("TEST_NICKNAME");
        returnEntity.setPassword("TEST_PASSWORD");
        returnEntity.setMail("TEST_MAIL");
        returnEntity.setOnlineStatus(true);

        return List.of(returnEntity);
    }

    private FindAllUserResponse response() {
        var dto = new UserEntityDTO(1L, "TEST_NICKNAME", "TEST_PASSWORD", "TEST_MAIL", true);
        return new FindAllUserResponse((List.of(dto)));
    }
}