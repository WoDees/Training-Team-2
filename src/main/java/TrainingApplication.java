import console.authorization.AuthorizationUIAction;
import console.authorization.RegistrationUserUIAction;
import console.*;
import console.authorization.VerifyUIAction;
import core.*;
import repository.ArrayListUserRepository;
import repository.ArrayListCalendarRepository;

import java.util.Arrays;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();
        var calendarRepository = new ArrayListCalendarRepository();

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);
        var calendarService = new CalendarService(calendarRepository);
        var registrationService = new RegistrationService(repository);
        var verifyService = new VerifyService(repository);
        var removeUserService = new RemoveUserService(repository);

        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RemoveUserUIAction(removeUserService)
        );

        var authorizationActions = Arrays.asList(
                new AuthorizationUIAction(new RegistrationUserUIAction(registrationService), new VerifyUIAction(verifyService))
        );

        var uiMenu = new UIMenu(actions, authorizationActions);
        uiMenu.startUI();

    }
}
