package com.trainingApplication.core.validation.trainingDays;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static test_factory.TestTrainingDaysDtoFactory.createAddCalendarRequest;
import static test_factory.TestTrainingDaysDtoFactory.createRequestWithoutEventDate;

@ExtendWith(MockitoExtension.class)
class CalendarValidationServiceTest {

    @Mock
    private TrainingDaysValidationRule trainingDaysValidationRule;

    @Captor
    private ArgumentCaptor<AddTrainingDaysRequest> addCalendarRequestArgumentCaptor;

    private TrainingDaysValidationService trainingDaysValidationService;

    @BeforeEach
    void setUp() {
        trainingDaysValidationService = new TrainingDaysValidationService(List.of(trainingDaysValidationRule));
    }

    @Test
    void shouldMapErrors() {
        doThrow(new ValidationException("Test_Exception")).when(trainingDaysValidationRule).validate(any());
        var request = createRequestWithoutEventDate();

        var actual = trainingDaysValidationService.validate(request);

        verify(trainingDaysValidationRule).validate(addCalendarRequestArgumentCaptor.capture());
        var captureRequest = addCalendarRequestArgumentCaptor.getValue();

        assertNotNull(captureRequest);
        assertEquals("Test_Description", captureRequest.getDescription());

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("Test_Exception"));
    }

    @Test
    void shouldNotMapErrors() {

        var request = createAddCalendarRequest();

        var actualResult = trainingDaysValidationService.validate(request);

        verify(trainingDaysValidationRule).validate(addCalendarRequestArgumentCaptor.capture());
        var captureRequest = addCalendarRequestArgumentCaptor.getValue();

        System.out.println(captureRequest);

        assertEquals(actualResult, List.of());
        assertEquals(captureRequest, request);
    }
}
