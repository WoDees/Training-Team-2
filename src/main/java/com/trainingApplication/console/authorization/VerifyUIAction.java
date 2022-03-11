package com.trainingApplication.console.authorization;

import com.trainingApplication.core.service.VerifyUserService;
import com.trainingApplication.dto.request.VerifyUserRequest;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class VerifyUIAction implements UIAuthorization {

    private final VerifyUserService verifyService;

    public VerifyUIAction(VerifyUserService verifyService) {
        this.verifyService = verifyService;
    }

    @Override
    public Long execute() {
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
