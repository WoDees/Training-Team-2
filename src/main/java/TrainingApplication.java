
import console.ActivitiesCaloriesUserUIAction;
import console.CalendarUserUIAction;
import console.RegistrationUserUIAction;
import console.UIMenu;
import core.ActivitiesCaloriesService;
import core.CalendarService;
import core.RegistrationService;
import repository.FileUserRepository;

import java.util.Arrays;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new FileUserRepository();

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);

        var calendarService = new CalendarService(repository);

        var registrationService = new RegistrationService(repository);

        var actions =Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RegistrationUserUIAction(registrationService)
        );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();

    }
}
