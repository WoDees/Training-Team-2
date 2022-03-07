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

        verifyService.findAll().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your nickname: ");
        String nickname = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();


        var request = new VerifyUserRequest();
        request.setNickname(nickname);
        request.setPassword(password);

        var response = verifyService.entrance(request);
        System.out.println("Received response: " + response);

        return response.getUserId();
    }

    @Override
    public String getActionName() {
        return "Log In";
    }
}
