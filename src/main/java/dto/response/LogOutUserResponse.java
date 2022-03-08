package dto.response;

import java.util.Objects;

public class LogOutUserResponse {

    private Long userId;
    private boolean onlineStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        LogOutUserResponse that = (LogOutUserResponse) o;
        return onlineStatus == that.onlineStatus && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, onlineStatus);
    }

    @Override
    public String toString() {
        return "LogOutUserResponse{" +
                "userId=" + userId +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
