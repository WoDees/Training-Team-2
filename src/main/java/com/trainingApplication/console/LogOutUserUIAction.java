package com.trainingApplication.console;

import com.trainingApplication.core.service.LogOutUserService;
import com.trainingApplication.dto.request.LogOutUserRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(6)
@Component
public class LogOutUserUIAction implements UIAction {

    private final LogOutUserService logOutService;

    public LogOutUserUIAction(LogOutUserService logOutService) {
        this.logOutService = logOutService;
    }

    @Override
    public void execute(Long userId) {
        var request = new LogOutUserRequest();
        request.setUserId(userId);
        request.setOnlineStatus(false);
        var response = logOutService.logOut(request);
        System.out.println("Received response: " + response);

        System.out.println("See you soon!");
    }

    @Override
    public String getActionName() {
        return "Log Out";
    }
}
