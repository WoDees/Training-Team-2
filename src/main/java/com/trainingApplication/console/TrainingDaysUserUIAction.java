package com.trainingApplication.console;

import com.trainingApplication.core.service.TrainingDaysService;
import com.trainingApplication.dto.request.AddTrainingDaysRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(1)
@Component
public class TrainingDaysUserUIAction implements UIAction {

    private final TrainingDaysService trainingDaysService;

    public TrainingDaysUserUIAction(TrainingDaysService trainingDaysService) {
        this.trainingDaysService = trainingDaysService;
    }

    @Override
    public void execute(Long userId) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter training date (format dd/mm/yyyy): ");
        var trainingDate = scanner.nextLine();
        System.out.println("Enter description: ");
        var description = scanner.nextLine();

        var request = new AddTrainingDaysRequest();
        request.setEventDate(trainingDate);
        request.setDescription(description);
        request.setUserId(userId);
        System.out.println("Successfully saved: " + request);

        var response = trainingDaysService.add(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Add training days";
    }
}
