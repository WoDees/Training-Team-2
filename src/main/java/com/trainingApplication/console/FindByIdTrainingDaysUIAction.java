package com.trainingApplication.console;

import com.trainingApplication.core.service.FindByIdTrainingDaysService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(3)
@Component
public class FindByIdTrainingDaysUIAction implements UIAction {

    private final FindByIdTrainingDaysService findByIdTrainingDaysService;

    public FindByIdTrainingDaysUIAction(FindByIdTrainingDaysService findByIdTrainingDaysService) {
        this.findByIdTrainingDaysService = findByIdTrainingDaysService;
    }

    @Override
    public void execute(Long userId) {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter training day id:");
        var id = scanner.nextLong();
        var result = findByIdTrainingDaysService.getById(id);
        System.out.println("Result: " + result);
    }

    @Override
    public String getActionName() {
        return "Find by id training days";
    }
}
