import java.util.Objects;

class User {

    private int userId;
    private String nickName;
    private String password;
    private String mail;

    public User(String nickName, String password, String mail) {
        this.nickName = nickName;
        this.password = password;
        this.mail = mail;
    }

    public User(int userId, String nickName, String password, String mail) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.mail = mail;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return userId == that.userId && Objects.equals(nickName, that.nickName) && Objects.equals(password, that.password) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickName, password, mail);
    }
}
