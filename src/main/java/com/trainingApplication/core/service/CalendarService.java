package com.trainingApplication.core.service;

import com.trainingApplication.core.validation.calendar.CalendarValidationService;
import com.trainingApplication.domain.CalendarEntity;
import com.trainingApplication.dto.request.AddCalendarRequest;
import com.trainingApplication.dto.response.AddCalendarResponse;
import com.trainingApplication.dto.CalendarDTO;
import com.trainingApplication.dto.response.FindAllCalendarResponse;
import com.trainingApplication.repository.ArrayListCalendarRepository;
import org.springframework.stereotype.Service;

@Service
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
        response.setCreatedCalendarId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private CalendarEntity convert(AddCalendarRequest request) {
        CalendarEntity entity = new CalendarEntity();
        entity.setEventDate(request.getEventDate());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public FindAllCalendarResponse findAll() {
        var dtos = repository.findAll().stream()
                .map(this::convert)
                .toList();
        return new FindAllCalendarResponse(dtos);
    }

    private CalendarDTO convert(CalendarEntity entity) {
        return new CalendarDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getEventDate());
    }
}

