package com.trainingApplication.console.authorization;

import com.trainingApplication.core.service.AddUserService;
import com.trainingApplication.dto.request.AddUserRequest;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddUserUIAction implements UIAuthorization {

    private final AddUserService addUserService;

    public AddUserUIAction(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    @Override
    public Long execute() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter your nickname: ");
        var nickname = scanner.nextLine();
        System.out.println("Please enter your e-mail: ");
        var mail = scanner.nextLine();
        System.out.println("Please enter your password: ");
        var password = scanner.nextLine();

        var request = new AddUserRequest();
        request.setNickname(nickname);
        request.setPassword(password);
        request.setMail(mail);

        var response = addUserService.add(request);
        System.out.println("Received response: " + response);
        return response.getCreatedUserId();
    }

    @Override
    public String getActionName() {
        return "Registration";
    }
}
