package core.service;

import core.validation.calendar.CalendarValidationService;
import domain.CalendarEntity;
import dto.request.AddCalendarRequest;
import dto.response.AddCalendarResponse;
import repository.ArrayListCalendarRepository;

import java.util.List;

public class CalendarService {

    private final ArrayListCalendarRepository repository;
    private final CalendarValidationService calendarValidationService;

    public CalendarService(ArrayListCalendarRepository repository, CalendarValidationService calendarValidationService) {
        this.repository = repository;
        this.calendarValidationService = calendarValidationService;
    }

    public AddCalendarResponse add(AddCalendarRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = calendarValidationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddCalendarResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddCalendarResponse();
        response.setCreatedCalendarId((int) createdEntity.getId());
        return response;
    }

    private CalendarEntity convert(AddCalendarRequest request) {
        CalendarEntity entity = new CalendarEntity();
        entity.setEventDate(request.getEventDate());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public List<CalendarEntity> findAll() {
        return repository.findAll();
    }
}

