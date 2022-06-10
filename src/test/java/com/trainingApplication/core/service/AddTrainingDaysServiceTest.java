package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.dto.response.AddTrainingDaysResponse;
import com.trainingApplication.repository.training_day.TrainingDayRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static test_factory.TestTrainingDaysDtoFactory.createEntity;
import static test_factory.TestTrainingDaysDtoFactory.createRequest;

@ExtendWith(MockitoExtension.class)
class AddTrainingDaysServiceTest {

    @Mock
    private TrainingDayRepository repository;

    @InjectMocks
    private AddTrainingDaysService addTrainingDaysService;

    @Test
    void shouldSuccessfullyAddCalendarDate() {
        var request = createRequest();
        doReturn(createEntity(123L)).when(repository).save(createEntity(null));

        var actualResult = addTrainingDaysService.add(createRequest());

        verify(repository).save(any());

        var expectedResult = new AddTrainingDaysResponse();
        expectedResult.setErrors(null);
        expectedResult.setCreatedTrainingDaysId(123L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrors() {

        var actualResult = addTrainingDaysService.add(createRequest());

        verifyNoInteractions(repository);

        var expectedResult = new AddTrainingDaysResponse();
        expectedResult.setErrors(List.of(new CoreError("Test Error")));
        expectedResult.setCreatedTrainingDaysId(null);

        assertEquals(expectedResult, actualResult);
    }
}
