package com.trainingApplication.console;

import com.trainingApplication.core.service.QuizService;
import com.trainingApplication.dto.request.QuizRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(6)
@Component
public class QuizUIAction implements UIAction {

    private final QuizService quizService;

    public QuizUIAction(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public void execute(Long userId) {
        var scanner = new Scanner(System.in);
        System.out.println("""
                1 - Male
                2 - Female
                Please enter your gender:\s""");
        Long gender = Long.valueOf(scanner.nextLine());
        System.out.println("Please enter your age: ");
        Long age = Long.valueOf(scanner.nextLine());
        System.out.println("Please enter your weight: ");
        Long weight = Long.valueOf(scanner.nextLine());

        System.out.println("Please enter your growth: ");
        Long growth = Long.valueOf(scanner.nextLine());
        System.out.println("Please enter your desired weight: ");
        Long desiredWeight = Long.valueOf(scanner.nextLine());
        System.out.println("Please enter your goal weight loss: ");
        String target = scanner.nextLine();

        var request = new QuizRequest();
        request.setGender(gender);
        request.setAge(age);
        request.setWeight(weight);
        request.setGrowth(growth);
        request.setDesiredWeight(desiredWeight);
        request.setTarget(target);
        request.setUserId(userId);
        System.out.println("Successfully saved: " + request);

        var response = quizService.addQuiz(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Quiz";
    }
}
