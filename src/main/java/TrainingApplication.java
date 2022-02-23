import console.authorization.AuthorizationUIAction;
import console.authorization.AddUserUIAction;
import console.*;
import console.authorization.VerifyUIAction;
import core.*;
import core.validation.ValidationService;
import core.validation.authorization.AddUserMailValidationRule;
import core.validation.authorization.AddUserNickNameValidationRule;
import core.validation.authorization.AddUserPasswordValidationRule;
import repository.ArrayListUserRepository;
import repository.ArrayListCalendarRepository;

import java.util.Arrays;
import java.util.List;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();
        var calendarRepository = new ArrayListCalendarRepository();

        var validationRules = List.of(
                new AddUserNickNameValidationRule(),
                new AddUserPasswordValidationRule(),
                new AddUserMailValidationRule()
        );
        var validationService = new ValidationService(validationRules);

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);
        var calendarService = new CalendarService(calendarRepository);
        var registrationService = new AddUserService(repository, validationService);
        var verifyService = new VerifyUserService(repository);
        var removeUserService = new RemoveUserService(repository);
        var logOutUserService = new LogOutUserService(repository);

        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RemoveUserUIAction(removeUserService),
                new LogOutUserUIAction(logOutUserService)
        );

        var authorizationActions = List.of(
                new AuthorizationUIAction(new AddUserUIAction(registrationService), new VerifyUIAction(verifyService))
        );

        var uiMenu = new UIMenu(actions, authorizationActions);
        uiMenu.startUI();
    }
}
