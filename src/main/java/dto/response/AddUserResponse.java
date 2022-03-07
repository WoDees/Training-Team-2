package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class AddUserResponse {

    private Long createdUserId;
    private List<CoreError> errors;
    private boolean onlineStatus;

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

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddUserResponse that = (AddUserResponse) o;
        return onlineStatus == that.onlineStatus && Objects.equals(createdUserId, that.createdUserId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdUserId, errors, onlineStatus);
    }

    @Override
    public String toString() {
        return "AddUserResponse{" +
                "createdUserId=" + createdUserId +
                ", errors=" + errors +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
