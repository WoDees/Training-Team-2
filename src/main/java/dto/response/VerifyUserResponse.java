package dto.response;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class VerifyUserResponse {

    private boolean onlineStatus;
    private List<CoreError> errors;
    private Long userId;

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifyUserResponse that = (VerifyUserResponse) o;
        return onlineStatus == that.onlineStatus && Objects.equals(errors, that.errors) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(onlineStatus, errors, userId);
    }

    @Override
    public String toString() {
        return "VerifyUserResponse{" +
                "onlineStatus=" + onlineStatus +
                ", errors=" + errors +
                ", userId=" + userId +
                '}';
    }
}
