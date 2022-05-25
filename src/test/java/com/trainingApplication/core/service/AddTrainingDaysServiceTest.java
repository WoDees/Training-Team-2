package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.trainingDays.TrainingDaysValidationService;
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

    @Mock
    private TrainingDaysValidationService trainingDaysValidationService;

    @InjectMocks
    private AddTrainingDaysService addTrainingDaysService;

    @Test
    void shouldSuccessfullyAddCalendarDate() {
        var request = createRequest();
        doReturn(List.of()).when(trainingDaysValidationService).validate(request);
        doReturn(createEntity(123L)).when(repository).save(createEntity(null));

        var actualResult = addTrainingDaysService.add(createRequest());

        verify(repository).save(any());
        verify(trainingDaysValidationService).validate(any());

        var expectedResult = new AddTrainingDaysResponse();
        expectedResult.setErrors(null);
        expectedResult.setCreatedTrainingDaysId(123L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrors() {
        var request = createRequest();
        doReturn(List.of(new CoreError("Test Error"))).when(trainingDaysValidationService).validate(request);

        var actualResult = addTrainingDaysService.add(createRequest());

        verify(trainingDaysValidationService).validate(any());
        verifyNoInteractions(repository);

        var expectedResult = new AddTrainingDaysResponse();
        expectedResult.setErrors(List.of(new CoreError("Test Error")));
        expectedResult.setCreatedTrainingDaysId(null);

        assertEquals(expectedResult, actualResult);
    }
}
