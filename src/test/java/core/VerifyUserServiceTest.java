package core;

import core.service.VerifyUserService;
import domain.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerifyUserServiceTest {

    @Mock
    private Repository repository;

    @Mock
    private VerifyUserService verifyUserService;

    @Test
    void findAll() {
        var returnEntity = new UserEntity();
        returnEntity.setUserId(1L);
        returnEntity.setPassword("TEST_PASSWORD");
        returnEntity.setNickname("TEST_NICKNAME");
        returnEntity.setMail("TEST_MAIL");
        returnEntity.setOnlineStatus(true);
        var returnResult = List.of(returnEntity);

        when(repository.findAll()).thenReturn(returnResult);

        var result = verifyUserService.findAll();


        var expectedEntity = new UserEntity();

        expectedEntity.setUserId(1L);
        expectedEntity.setPassword("TEST_PASSWORD");
        expectedEntity.setNickname("TEST_NICKNAME");
        expectedEntity.setMail("TEST_MAIL");
        expectedEntity.setOnlineStatus(true);

        var expectedResult = List.of(expectedEntity);

        assertEquals(expectedResult,result);
    }

    private List<UserEntity> entities() {
        var returnEntity = new UserEntity();
        returnEntity.setUserId(0L);
        returnEntity.setPassword("TEST_PASSWORD1");
        returnEntity.setNickname("TEST_NICKNAME");
        returnEntity.setMail("TEST_MAIL");
        return List.of(returnEntity);
    }

    private List<UserEntity> entities1() {
        var returnEntity = new UserEntity();
        returnEntity.setUserId(0L);
        returnEntity.setPassword("TEST_PASSWORD2");
        returnEntity.setNickname("TEST_NICKNAME");
        returnEntity.setMail("TEST_MAIL");
        return List.of(returnEntity);
    }
}