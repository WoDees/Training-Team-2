package core;

import repository.UserRepository;

public class VerifyService {

    private final UserRepository repository;

    public VerifyService(UserRepository repository) {
        this.repository = repository;
    }

    public void entrance(String nickName, String password) {

        if (repository.verify(nickName, password)) {
            System.out.println("Log in successful");
        } else {
            System.out.println("Wrong password or nickname!");
        }
    }
}
