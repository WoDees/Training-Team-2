package com.trainingApplication.console;

import com.trainingApplication.core.service.FindAllTrainingDaysService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class FindAllTrainingDaysUIAction implements UIAction {

    private final FindAllTrainingDaysService findAllTrainingDaysService;

    public FindAllTrainingDaysUIAction(FindAllTrainingDaysService findAllTrainingDaysService) {
        this.findAllTrainingDaysService = findAllTrainingDaysService;
    }

    @Override
    public void execute(Long userId) {
        var response = findAllTrainingDaysService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find all training days";
    }
}
