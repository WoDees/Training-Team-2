package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class AddCalendarResponse {

    private Integer createdCalendarId;
    private List<CoreError> errors;

    public Integer getCreatedCalendarId() {
        return createdCalendarId;
    }

    public void setCreatedCalendarId(Integer createdCalendarId) {
        this.createdCalendarId = createdCalendarId;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCalendarResponse that = (AddCalendarResponse) o;
        return Objects.equals(createdCalendarId, that.createdCalendarId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdCalendarId, errors);
    }

    @Override
    public String toString() {
        return "AddCalendarResponse{" +
                "createdToDoId=" + createdCalendarId +
                ", errors=" + errors +
                '}';
    }
}