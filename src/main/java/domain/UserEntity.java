package domain;

import java.util.Objects;

public class UserEntity {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        return onlineStatus == entity.onlineStatus && Objects.equals(userId, entity.userId) && Objects.equals(nickname, entity.nickname) && Objects.equals(password, entity.password) && Objects.equals(mail, entity.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickname, password, mail, onlineStatus);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", nickName='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
