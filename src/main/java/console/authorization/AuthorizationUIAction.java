package console.authorization;

import java.util.Scanner;

public class AuthorizationUIAction {

    RegistrationUserUIAction registrationUserUIAction;
    VerifyUIAction verifyUIAction;

    public AuthorizationUIAction(RegistrationUserUIAction registrationUserUIAction, VerifyUIAction verifyUIAction) {
        this.registrationUserUIAction = registrationUserUIAction;
        this.verifyUIAction = verifyUIAction;
    }

    public String getActionName() {
        return "Authorization";
    }

    public Long authorization() {
        System.out.println("Registration - 1, login - 2");
        Scanner scanner = new Scanner(System.in);
        int authorizationMethod = scanner.nextInt();

        if (authorizationMethod == 1) {
            return registrationUserUIAction.registration();
        } else {
            return verifyUIAction.login();
        }
    }
}
