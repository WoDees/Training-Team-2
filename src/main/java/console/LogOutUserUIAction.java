package console;

import core.service.LogOutUserService;
import dto.request.LogOutUserRequest;

import java.util.Scanner;

public class LogOutUserUIAction implements UIAction {

    private final LogOutUserService logOutService;

    public LogOutUserUIAction(LogOutUserService logOutService) {
        this.logOutService = logOutService;
    }

    @Override
    public void execute(Long userId) {
        System.out.println("""
                Do you really want to log out?\s
                1 - Yes
                2 - No""");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        var request = new LogOutUserRequest();
        request.setUserId(userId);
        request.setOnlineStatus(false);
        var response = logOutService.logOut(request);
        System.out.println("Received response: " + response);

        if (answer == 1) {
            System.out.println("See you soon!");
            logOutService.logOut(userId);
        } else if (answer == 2) {
            System.out.println("Welcome back!");
        } else {
            System.out.println("Wrong number. Please try again!");
        }
    }

    @Override
    public String getActionName() {
        return "Log Out";
    }
}
