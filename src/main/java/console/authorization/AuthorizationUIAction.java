package console.authorization;

import java.util.Scanner;

public class AuthorizationUIAction {

    private AddUserUIAction addUserUIAction;
    private VerifyUIAction verifyUIAction;

    public AuthorizationUIAction(AddUserUIAction registrationUserUIAction, VerifyUIAction verifyUIAction) {
        this.addUserUIAction = registrationUserUIAction;
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
            return addUserUIAction.add();
        }
        if (authorizationMethod == 2) {
            return verifyUIAction.logIn();
        }
        System.out.println("Invalid choice");
        return null;
    }
}