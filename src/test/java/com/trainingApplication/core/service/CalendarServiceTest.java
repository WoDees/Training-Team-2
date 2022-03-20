package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.calendar.CalendarValidationService;
import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.dto.response.AddCalendarResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.trainingApplication.repository.ArrayListCalendarRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static test_factory.TestCalendarDtoFactory.*;

@ExtendWith(MockitoExtension.class)
class CalendarServiceTest {

    @Mock
    private ArrayListCalendarRepository repository;

    @Mock
    private CalendarValidationService calendarValidationService;

    @InjectMocks
    private CalendarService calendarService;

    @Test
    void shouldSuccessfullyAddCalendarDate() {
        var request = createRequest();
        doReturn(List.of()).when(calendarValidationService).validate(request);
        doReturn(createEntity(123L)).when(repository).save(createEntity(null));

        var actualResult = calendarService.add(createRequest());

        verify(repository).save(any());
        verify(calendarValidationService).validate(any());

        var expectedResult = new AddCalendarResponse();
        expectedResult.setErrors(null);
        expectedResult.setCreatedCalendarId(123L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrors() {
        var request = createRequest();
        doReturn(List.of(new CoreError("Test Error"))).when(calendarValidationService).validate(request);

        var actualResult = calendarService.add(createRequest());

        verify(calendarValidationService).validate(any());
        verifyNoInteractions(repository);

        var expectedResult = new AddCalendarResponse();
        expectedResult.setErrors(List.of(new CoreError("Test Error")));
        expectedResult.setCreatedCalendarId(null);

        assertEquals(expectedResult, actualResult);
    }
}
