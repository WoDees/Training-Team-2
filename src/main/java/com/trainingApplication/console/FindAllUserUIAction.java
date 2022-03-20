package com.trainingApplication.console;

import com.trainingApplication.core.service.FindAllUserService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class FindAllUserUIAction implements UIAction {

    private final FindAllUserService findAllUserService;

    public FindAllUserUIAction(FindAllUserService findAllUserService) {
        this.findAllUserService = findAllUserService;
    }

    @Override
    public void execute(Long userId) {
        var response = findAllUserService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find all users";
    }
}
