package dto;

import java.util.Objects;

public class AddCalendarRequest {

    private String eventDate;
    private String description;

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
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
        AddCalendarRequest that = (AddCalendarRequest) o;
        return Objects.equals(eventDate, that.eventDate) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventDate, description);
    }

    @Override
    public String toString() {
        return "AddCalendarRequest{" +
                "name='" + eventDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
