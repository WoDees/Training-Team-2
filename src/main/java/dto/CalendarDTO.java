package dto;

import java.util.Objects;

public class CalendarDTO {

    private final Long id;
    private final Long userId;
    private final String description;
    private final String eventDate;

    public CalendarDTO(Long id, Long userId, String description, String eventDate) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarDTO that = (CalendarDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(description, that.description) && Objects.equals(eventDate, that.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, description, eventDate);
    }

    @Override
    public String toString() {
        return "CalendarDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
