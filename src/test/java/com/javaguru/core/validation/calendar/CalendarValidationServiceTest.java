package com.javaguru.core.validation.calendar;

import com.trainingApplication.core.validation.CoreError;
import com.trainingApplication.core.validation.ValidationException;
import com.trainingApplication.core.validation.calendar.CalendarValidationRule;
import com.trainingApplication.core.validation.calendar.CalendarValidationService;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class CalendarValidationServiceTest {

    @Mock
    private CalendarValidationRule calendarValidationRule;

    @Mock
    private CalendarValidationService calendarValidationService;

    @BeforeEach
    void setUp() {
        calendarValidationService = new CalendarValidationService(List.of(calendarValidationRule));
    }

    @Test
    void shouldMapErrors() {
        doThrow(new ValidationException("Test_Exception")).when(calendarValidationRule).validate(any());
        var request = new AddCalendarRequest();

        var actual = calendarValidationService.validate(request);

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("Test_Exception"));
    }
}