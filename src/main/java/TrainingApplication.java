import console.authorization.AuthorizationUIAction;
import console.authorization.RegistrationUserUIAction;
import console.*;
import console.authorization.VerifyUIAction;
import core.*;
import core.validation.CalendarValidationService;
import core.validation.calendar.*;
import repository.ArrayListUserRepository;
import repository.ArrayListCalendarRepository;

import java.util.Arrays;
import java.util.List;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();
        var calendarRepository = new ArrayListCalendarRepository();

        var calendarValidationRules = List.of(
                new CalendarNameNullValidationRule(),
                new CalendarDescriptionNullValidationRule(),
                new CalendarDescriptionMaxLengthValidationRule(),
                new CalendarDescriptionMinLengthValidationRule(),
                new CalendarCorrectDateFormatValidationRule()
        );
        var calendarValidationService = new CalendarValidationService(calendarValidationRules);

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);
        var calendarService = new CalendarService(calendarRepository, calendarValidationService);
        var registrationService = new RegistrationService(repository);
        var verifyService = new VerifyService(repository);
        var removeUserService = new RemoveUserService(repository);
        var logOutUserService = new LogOutUserService(repository);


        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RemoveUserUIAction(removeUserService),
                new LogOutUserUIAction(logOutUserService)
        );

        var authorizationActions = List.of(
                new AuthorizationUIAction(new RegistrationUserUIAction(registrationService), new VerifyUIAction(verifyService))
        );

        var uiMenu = new UIMenu(actions, authorizationActions);
        uiMenu.startUI();
    }
}
