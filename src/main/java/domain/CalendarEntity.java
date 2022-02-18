package domain;

import java.util.Objects;

public class CalendarEntity {

    private long id;
    private long userId;
    private String description;
    private String eventDate;

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity calendar = (CalendarEntity) o;
        return id == calendar.id && userId == calendar.userId && Objects.equals(description, calendar.description) && Objects.equals(eventDate, calendar.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, description, eventDate);
    }

    @Override
    public String toString() {
        return "CalendarEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
