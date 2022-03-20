package com.trainingApplication.core.service;

import com.trainingApplication.domain.CalendarEntity;
import com.trainingApplication.dto.CalendarDTO;
import com.trainingApplication.dto.response.FindAllTrainingDaysResponse;
import com.trainingApplication.repository.ArrayListCalendarRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAllTrainingDaysService {

    private final ArrayListCalendarRepository repository;

    public FindAllTrainingDaysService(ArrayListCalendarRepository repository) {
        this.repository = repository;
    }

    public FindAllTrainingDaysResponse findAll() {
        var dtos = repository.findAllTrainingDays().stream()
                .map(this::convert)
                .toList();
        return new FindAllTrainingDaysResponse(dtos);
    }

    private CalendarDTO convert(CalendarEntity entity) {
        return new CalendarDTO(entity.getId(), entity.getUserId(), entity.getDescription(), entity.getEventDate());
    }
}
