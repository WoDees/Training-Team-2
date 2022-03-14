package test_factory;

import com.trainingApplication.domain.CalendarEntity;
import com.trainingApplication.dto.request.AddCalendarRequest;

import java.util.*;

public class TestCalendarDtoFactory {

    public static AddCalendarRequest createAddCalendarRequest() {
        var request = new AddCalendarRequest();
        request.setEventDate("14/03/2022");
        request.setDescription("Test_Description");
        return request;
    }

    public static AddCalendarRequest createRequestWithoutDescription() {
        var request = new AddCalendarRequest();
        request.setEventDate("14/03/2022");
        return request;
    }

    public static AddCalendarRequest createRequestWithoutEventDate() {
        var request = new AddCalendarRequest();
        request.setDescription("Test_Description");
        return request;
    }

    public static CalendarEntity createEntity(Long id) {
        var entity = new CalendarEntity();
        entity.setId(id);
        entity.setUserId(id);
        entity.setEventDate("28/02/2022");
        entity.setDescription("Test description");
        return entity;
    }

    public static AddCalendarRequest createRequest() {
        var request = new AddCalendarRequest();
        request.setEventDate("28/02/2022");
        request.setDescription("Test description");
        return request;
    }

    public static List<CalendarEntity> createEntities() {
        var returnEntity = new CalendarEntity();
        returnEntity.setId(1L);
        returnEntity.setUserId(1L);
        returnEntity.setDescription("Test description");
        returnEntity.setEventDate("28/02/2022");
        return List.of(returnEntity);
    }
}
