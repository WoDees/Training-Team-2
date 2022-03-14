package com.trainingApplication.core.validation.calendar;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.dto.request.AddCalendarRequest;
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
import static test_factory.TestCalendarDtoFactory.createAddCalendarRequest;
import static test_factory.TestCalendarDtoFactory.createRequestWithoutEventDate;

@ExtendWith(MockitoExtension.class)
class CalendarValidationServiceTest {

    @Mock
    private CalendarValidationRule calendarValidationRule;

    @Captor
    private ArgumentCaptor<AddCalendarRequest> addCalendarRequestArgumentCaptor;

    private CalendarValidationService calendarValidationService;

    @BeforeEach
    void setUp() {
        calendarValidationService = new CalendarValidationService(List.of(calendarValidationRule));
    }

    @Test
    void shouldMapErrors() {
        doThrow(new ValidationException("Test_Exception")).when(calendarValidationRule).validate(any());
        var request = createRequestWithoutEventDate();

        var actual = calendarValidationService.validate(request);

        verify(calendarValidationRule).validate(addCalendarRequestArgumentCaptor.capture());
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

        var actualResult = calendarValidationService.validate(request);

        verify(calendarValidationRule).validate(addCalendarRequestArgumentCaptor.capture());
        var captureRequest = addCalendarRequestArgumentCaptor.getValue();

        System.out.println(captureRequest);

        assertEquals(actualResult, List.of());
        assertEquals(captureRequest, request);
    }
}