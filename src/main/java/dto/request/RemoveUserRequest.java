package dto.request;

import java.util.Objects;

public class RemoveUserRequest {

    private String nickname;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveUserRequest that = (RemoveUserRequest) o;
        return Objects.equals(nickname, that.nickname) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, password);
    }

    @Override
    public String toString() {
        return "RemoveUserRequest{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
