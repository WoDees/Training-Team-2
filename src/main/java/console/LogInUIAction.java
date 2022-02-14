package console;

import core.LogInService;

import java.util.Scanner;

public class LogInUIAction implements UIAction {

    private final LogInService logInService;

    public LogInUIAction(LogInService logInService) {
        this.logInService = logInService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        logInService.entrance(nickName, password);
    }

    @Override
    public String getActionName() {
        return "LogIn";
    }
}
