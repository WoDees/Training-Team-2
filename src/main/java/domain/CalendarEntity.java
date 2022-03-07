package domain;

import java.util.Objects;

public class CalendarEntity {

    private Long id;
    private Long userId;
    private String description;
    private String eventDate;

    public String getEventDate() {
        return eventDate;
    }

    public String setEventDate(String eventDate) {
        this.eventDate = eventDate;
        return eventDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity that = (CalendarEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(description, that.description) && Objects.equals(eventDate, that.eventDate);
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
