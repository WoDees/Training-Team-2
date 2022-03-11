package com.trainingApplication.console;

import com.trainingApplication.core.service.CalendarService;
import com.trainingApplication.dto.request.AddCalendarRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(1)
@Component
public class CalendarUserUIAction implements UIAction {

    private final CalendarService calendarService;

    public CalendarUserUIAction(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Override
    public void execute(Long userId) {
        System.out.println("Enter date (format dd/mm/yyyy): ");
        Scanner scanner = new Scanner(System.in);
        String eventDate = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        var request = new AddCalendarRequest();
        request.setEventDate(eventDate);
        request.setDescription(description);
        System.out.println("Successfully saved: " + request);

        var response = calendarService.add(request);
        System.out.println("Received response: " + response);
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
