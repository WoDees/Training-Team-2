package dto.request;

import java.util.Objects;

public class AddUserRequest {

    private String nickName;
    private String mail;
    private String password;
    private Long userId;
    private boolean onlineStatus;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
      
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        AddUserRequest that = (AddUserRequest) o;
        return onlineStatus == that.onlineStatus && Objects.equals(nickName, that.nickName) && Objects.equals(mail, that.mail) && Objects.equals(password, that.password) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, mail, password, userId, onlineStatus);
    }

    @Override
    public String toString() {
        return "AddUserRequest{" +
                "nickName='" + nickName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
