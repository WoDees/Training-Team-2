package core;

import repository.UserRepository;

public class RemoveUserService {

    private final UserRepository repository;

    public RemoveUserService(UserRepository repository) {
        this.repository = repository;
    }

    public void delete(String login, String password) {

        if (repository.remove(login, password)) {
            System.out.println("Account was successful deleted!");
        } else {
            System.out.println("Account does not exist!");
        }
    }
}
