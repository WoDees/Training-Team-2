package console;

import core.LogOutUserService;

import java.util.Scanner;

public class LogOutUserUIAction implements UIAction {

    private final LogOutUserService logOutService;

    public LogOutUserUIAction(LogOutUserService logOutService) {
        this.logOutService = logOutService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you really want to log out? " +
                "\n" + "1 - Yes" +
                "\n" + "2 - No");
        int answer = scanner.nextInt();
        if (answer == 1) {
            logOutService.logOut(userId);
            System.out.println(logOutService.findAll());
        }
    }

    @Override
    public String getActionName() {
        return "Logout";
    }
}
