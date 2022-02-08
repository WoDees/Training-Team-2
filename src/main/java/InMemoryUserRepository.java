import java.util.LinkedList;
import java.util.List;

class InMemoryUserRepository implements UserRepository {

    private final List<User> userList = new LinkedList<>();
    private int sequence = 0;

    @Override
    public int save(User user) {
        user.setUserId(++sequence);
        userList.add(user);
        return user.getUserId();
    }

    @Override
    public boolean delete(User user) {
        return userList.remove(user);
    }

    @Override
    public boolean updatePassword(User user, String newPassword) {
        if (userList.contains(user)) {
            userList.get(user.getUserId()).setPassword(newPassword);
            return true;
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }
}
