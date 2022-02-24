package domain;

import java.util.Objects;

public class UserEntity {

    private Long userId;
    private String nickName;
    private String password;
    private String mail;
    private boolean onlineStatus;

    public Long getUserId() {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
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
        UserEntity entity = (UserEntity) o;
        return onlineStatus == entity.onlineStatus && Objects.equals(userId, entity.userId) && Objects.equals(nickName, entity.nickName) && Objects.equals(password, entity.password) && Objects.equals(mail, entity.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickName, password, mail, onlineStatus);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
