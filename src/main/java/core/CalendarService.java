package core;

import domain.UserEntity;
import repository.UserRepository;

import java.util.List;

public class CalendarService {

    public final UserRepository repository;

    public CalendarService(UserRepository repository) {
        this.repository = repository;
    }

    public void days(int weekdays) {
        if (weekdays == 1) {
            System.out.println("Monday,Tuesday,Wednesday");
        } else if (weekdays == 2) {
            System.out.println("Thursday,Friday,Saturday");
        } else if (weekdays == 3) {
            System.out.println("Friday,Saturday,Sunday");
        } else if (weekdays == 4) {
            System.out.println("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday");
        }
    }

    public void add(UserEntity userEntity) {
        repository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
