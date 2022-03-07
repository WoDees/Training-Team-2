package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class AddUserResponse {

    private Long createdUserId;
    private List<CoreError> errors;

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
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
        AddUserResponse that = (AddUserResponse) o;
        return Objects.equals(createdUserId, that.createdUserId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdUserId, errors);
    }

    @Override
    public String toString() {
        return "AddUserResponse{" +
                "createdUserId=" + createdUserId +
                ", errors=" + errors +
                '}';
    }
}
