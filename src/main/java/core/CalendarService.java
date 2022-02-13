package core;

import repository.UserRepository;

public class CalendarService {

    private final UserRepository repositoryl;

    public CalendarService(UserRepository repositoryl) {
        this.repositoryl = repositoryl;
    }
}
