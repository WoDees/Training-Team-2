package domain;

import java.util.Objects;

public class UserEntity {

    private int userId;
    private String nickName;
    private String password;
    private String mail;
    private int trainingDayAmount;

    public int getTrainingDayAmount() {
        return trainingDayAmount;
    }

    public void setTrainingDayAmount(int trainingDayAmount) {
        this.trainingDayAmount = trainingDayAmount;
    }

    public int getUserId() {
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

    public void setUserId(int userId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && Objects.equals(nickName, that.nickName) && Objects.equals(password, that.password) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickName, password, mail, trainingDayAmount);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", trainingDay=" + trainingDayAmount +
                '}';
    }
}
