package core;

import repository.UserRepository;

public class LogInService {

    private final UserRepository repository;

    public LogInService(UserRepository repository) {
        this.repository = repository;
    }

    public void entrance(String nickName, String password) {
        repository.logIn(nickName, password);
    }
}
