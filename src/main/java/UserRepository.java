interface UserRepository {

    int save(User user);

    boolean delete(User user);

    boolean updatePassword(User user, String newPassword);
}
