package dto.request;

import java.util.Objects;

public class AddUserRequest {

    private String nickName;
    private String password;
    private String mail;
    private boolean onlineStatus;

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
        return onlineStatus == that.onlineStatus && Objects.equals(nickName, that.nickName) && Objects.equals(password, that.password) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, password, mail, onlineStatus);
    }

    @Override
    public String toString() {
        return "AddUserRequest{" +
                "nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
