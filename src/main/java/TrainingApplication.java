import console.LogInUIAction;
import console.RegistrationUserUIAction;
import console.*;
import core.ActivitiesCaloriesService;
import core.CalendarService;
import core.LogInService;
import core.RegistrationService;
import repository.ArrayListUserRepository;

import java.util.Arrays;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);

        var calendarService = new CalendarService(repository);

        var registrationService = new RegistrationService(repository);

        var logInService = new LogInService(repository);

        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RegistrationUserUIAction(registrationService),
                new LogInUIAction(logInService)
        );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();

    }

}
