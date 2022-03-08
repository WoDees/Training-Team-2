package dto;

import java.util.Objects;

public class UserEntityDTO {

    private Long userId;
    private String nickname;
    private String password;
    private String mail;
    private boolean onlineStatus;

    public UserEntityDTO(Long userId, String nickname, String password, String mail, boolean onlineStatus) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.mail = mail;
        this.onlineStatus = onlineStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDTO that = (UserEntityDTO) o;
        return onlineStatus == that.onlineStatus && Objects.equals(userId, that.userId) && Objects.equals(nickname, that.nickname) && Objects.equals(password, that.password) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickname, password, mail, onlineStatus);
    }

    @Override
    public String toString() {
        return "UserEntityDTO{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
