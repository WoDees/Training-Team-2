package dto;

import java.util.List;
import java.util.Objects;

public class FindAllCalendarResponse {

    private final List<CalendarDTO> calendars;

    public FindAllCalendarResponse(List<CalendarDTO> calendars) {
        this.calendars = calendars;
    }

    public List<CalendarDTO> getCalendars() {
        return calendars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllCalendarResponse that = (FindAllCalendarResponse) o;
        return Objects.equals(calendars, that.calendars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendars);
    }

    @Override
    public String toString() {
        return "FindAllCalendarResponse{" +
                "calendars=" + calendars +
                '}';
    }
}
