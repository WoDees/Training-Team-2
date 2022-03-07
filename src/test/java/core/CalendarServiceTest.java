package core;

import core.validation.CalendarValidationService;
import core.validation.CoreError;
import domain.CalendarEntity;
import dto.AddCalendarRequest;
import dto.AddCalendarResponse;
import dto.CalendarDTO;
import dto.FindAllCalendarResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ArrayListCalendarRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalendarServiceTest {

    @Mock
    private ArrayListCalendarRepository repository;

    @Mock
    private CalendarValidationService calendarValidationService;

    @InjectMocks
    private CalendarService calendarService;

    @Test
    void shouldFindAllTrainingDays() {

        var returnResult = entities();
        doReturn(returnResult).when(repository).findAll();

        var actualResult = calendarService.findAll();

        var expectedResult = response();

        assertEquals(expectedResult, actualResult);

    }

    private List<CalendarEntity> entities() {
        var returnEntity = new CalendarEntity();
        returnEntity.setId(1L);
        returnEntity.setUserId(1L);
        returnEntity.setDescription("Test description");
        returnEntity.setEventDate("28/02/2022");
        return List.of(returnEntity);
    }

    private FindAllCalendarResponse response() {
        var dto = new CalendarDTO(1L, 1L, "Test description", "28/02/2022");
        return new FindAllCalendarResponse(List.of(dto));
    }

    @Test
    void shouldSuccessfullyAddCalendarDate() {
        var request = request();
        doReturn(List.of()).when(calendarValidationService).validate(request);
        doReturn(entity(123L)).when(repository).save(entity(null));

        var actualResult = calendarService.add(request());

        verify(repository).save(any());
        verify(calendarValidationService).validate(any());

        var expectedResult = new AddCalendarResponse();
        expectedResult.setErrors(null);
        expectedResult.setCreatedCalendarId(123L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnErrors() {
        var request = request();
        doReturn(List.of(new CoreError("Test Error"))).when(calendarValidationService).validate(request);

        var actualResult = calendarService.add(request());

        verify(calendarValidationService).validate(any());
        verifyNoInteractions(repository);

        var expectedResult = new AddCalendarResponse();
        expectedResult.setErrors(List.of(new CoreError("Test Error")));
        expectedResult.setCreatedCalendarId(null);

        assertEquals(expectedResult, actualResult);
    }

    private AddCalendarRequest request() {
        var request = new AddCalendarRequest();
        request.setEventDate("28/02/2022");
        request.setDescription("Test description");
        return request;
    }

    private CalendarEntity entity(Long id) {
        var entity = new CalendarEntity();
        entity.setId(id);
        entity.setUserId(id);
        entity.setEventDate("28/02/2022");
        entity.setDescription("Test description");
        return entity;
    }
}