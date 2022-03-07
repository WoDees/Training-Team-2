import console.authorization.AddUserUIAction;
import console.*;
import console.authorization.VerifyUIAction;
import core.service.*;
import core.validation.authorization.verify.VerifyAttemptsAmountValidationRule;
import core.validation.authorization.verify.VerifyExistenceValidationRule;
import core.validation.authorization.verify.VerifyUserInputValidationRule;
import core.validation.authorization.verify.VerifyValidationService;
import core.validation.calendar.CalendarValidationService;
import core.validation.authorization.registration.RegistrationValidationService;
import core.validation.authorization.registration.RegistrationUserMailValidationRule;
import core.validation.authorization.registration.RegistrationUserNickNameValidationRule;
import core.validation.authorization.registration.RegistrationUserPasswordValidationRule;
import core.validation.calendar.*;
import core.validation.remove.RemoveExistenceValidationRule;
import core.validation.remove.RemoveUserInputValidationRule;
import core.validation.remove.RemoveValidationService;
import repository.ArrayListUserRepository;
import repository.ArrayListCalendarRepository;

import java.util.Arrays;
import java.util.List;

public class TrainingApplication {

    public static void main(String[] args) {

        var repository = new ArrayListUserRepository();
        var calendarRepository = new ArrayListCalendarRepository();

        var calendarValidationRules = List.of(
                new CalendarDescriptionLengthValidationRule(),
                new CalendarDateFormatValidationRule()
        );
        var calendarValidationService = new CalendarValidationService(calendarValidationRules);

        var registrationValidationRules = List.of(
                new RegistrationUserNickNameValidationRule(repository),
                new RegistrationUserPasswordValidationRule(),
                new RegistrationUserMailValidationRule(repository)
        );
        var registrationValidationService = new RegistrationValidationService(registrationValidationRules);

        var verifyValidationRules = List.of(
                new VerifyUserInputValidationRule(repository),
                new VerifyAttemptsAmountValidationRule(repository),
                new VerifyExistenceValidationRule(repository)
        );
        var verifyValidationService = new VerifyValidationService(verifyValidationRules);

        var removeValidationRules = List.of(
                new RemoveExistenceValidationRule(repository),
                new RemoveUserInputValidationRule(repository)
        );
        var removeValidationService = new RemoveValidationService(removeValidationRules);

        var activitiesCaloriesService = new ActivitiesCaloriesService(repository);
        var calendarService = new CalendarService(calendarRepository, calendarValidationService);
        var addUserService = new AddUserService(repository, registrationValidationService);
        var verifyService = new VerifyUserService(repository, verifyValidationService);
        var removeUserService = new RemoveUserService(repository,removeValidationService);
        var logOutUserService = new LogOutUserService(repository);


        var actions = Arrays.asList(
                new ActivitiesCaloriesUserUIAction(activitiesCaloriesService),
                new CalendarUserUIAction(calendarService),
                new RemoveUserUIAction(removeUserService),
                new LogOutUserUIAction(logOutUserService)
        );

        var authorizationActions = List.of(
                new AddUserUIAction(addUserService),
                new VerifyUIAction(verifyService)
        );

        var uiMenu = new UIMenu(actions, authorizationActions);
        uiMenu.startUI();
    }
}
