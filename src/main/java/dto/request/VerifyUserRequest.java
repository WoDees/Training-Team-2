package dto.request;

import java.util.Objects;

public class VerifyUserRequest {

    private String nickName;
    private String password;
    private boolean onlineStatus;
    private Long userId;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
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
        VerifyUserRequest that = (VerifyUserRequest) o;
        return onlineStatus == that.onlineStatus && Objects.equals(nickName, that.nickName) && Objects.equals(password, that.password) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, password, onlineStatus, userId);
    }

    @Override
    public String toString() {
        return "VerifyUserRequest{" +
                "nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", onlineStatus=" + onlineStatus +
                ", userId=" + userId +
                '}';
    }
}
