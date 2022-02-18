package core;

import domain.CalendarEntity;
import domain.UserEntity;
import repository.ArrayListCalendarRepository;

import java.util.List;

public class CalendarService {

    private final ArrayListCalendarRepository repository;

    public CalendarService(ArrayListCalendarRepository repository) {
        this.repository = repository;
    }

    public void add(CalendarEntity calendar) {
        repository.save(calendar);
    }

    public List<CalendarEntity> findAll() {
        return repository.findAll();
    }
}
