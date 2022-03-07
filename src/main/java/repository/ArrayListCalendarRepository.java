package repository;

import domain.CalendarEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListCalendarRepository {

    private final List<CalendarEntity> dataBase = new ArrayList<>();
    private Long sequence = 0L;

    public List<CalendarEntity> findCalendarsByUserId(Long id) {

        List<CalendarEntity> userDays = new ArrayList<>();

        for (CalendarEntity calendar : dataBase) {
            if (Objects.equals(calendar.getUserId(), id)) {
                userDays.add(calendar);
            }
        }
        return userDays;
    }

    public CalendarEntity save(CalendarEntity calendarEntity) {
        calendarEntity.setUserId(sequence);
        sequence++;
        dataBase.add(calendarEntity);
        return calendarEntity;
    }

    public List<CalendarEntity> findAll() {
        return dataBase;
    }
}