package core;

import repository.Repository;

public class RemoveUserService {

    private final Repository repository;

    public RemoveUserService(Repository repository) {
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
