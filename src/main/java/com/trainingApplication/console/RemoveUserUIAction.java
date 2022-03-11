package com.trainingApplication.console;

import com.trainingApplication.core.service.RemoveUserService;
import com.trainingApplication.dto.request.RemoveUserRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(3)
@Component
public class RemoveUserUIAction implements UIAction {

    private final RemoveUserService removeUserService;

    public RemoveUserUIAction(RemoveUserService removeUserService) {
        this.removeUserService = removeUserService;
    }

    @Override
    public void execute(Long userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname:");
        String nickname = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        var request = new RemoveUserRequest();
        request.setNickname(nickname);
        request.setPassword(password);

        var response = removeUserService.remove(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Remove";
    }
}
