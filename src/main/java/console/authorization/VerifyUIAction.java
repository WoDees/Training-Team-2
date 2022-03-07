package console.authorization;

import core.VerifyUserService;
import dto.request.VerifyUserRequest;

import java.util.Scanner;

public class VerifyUIAction implements UIAuthorization {

    private final VerifyUserService verifyService;

    public VerifyUIAction(VerifyUserService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    public Long execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickName: ");
        String nickName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();


        var request = new VerifyUserRequest();
        request.setNickName(nickName);
        request.setPassword(password);
        request.setOnlineStatus(true);

        var response = verifyService.entrance(request);
        System.out.println("Received response: " + response);

        if (response.isOnlineStatus()) {
            System.out.println("Log in successful!");
            return response.getUserId();
        } else {
            System.out.println("Incorrect nickname or password");
            return null;
        }
    }

    @Override
    public String getActionName() {
        return "Log In";
    }
}
