import console.RegistrationUserUIAction;
import console.*;
import core.*;
import repository.ArrayListUserRepository;

import java.util.Arrays;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);
        var calendarService = new CalendarService(repository);
        var registrationService = new RegistrationService(repository);
        var verifyService = new VerifyService(repository);
        var removeUserService = new RemoveUserService(repository);

        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RegistrationUserUIAction(registrationService),
                new VerifyUIAction(verifyService),
                new RemoveUserUIAction(removeUserService)
        );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();

    }
}
