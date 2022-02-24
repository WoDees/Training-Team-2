package console;

import core.CalendarService;
import core.validation.CalendarValidationService;
import domain.CalendarEntity;
import dto.AddCalendarRequest;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalendarUserUIAction implements UIAction {


    private final CalendarService calendarService;


    public CalendarUserUIAction(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Override
    public void execute(Long userId) {
        CalendarEntity calendar;
        calendar = new CalendarEntity();

        System.out.println("Enter date (format dd/mm/yyyy): ");
        Scanner scanner = new Scanner(System.in);
        String eventDate = calendar.setEventDate(scanner.nextLine());
        System.out.println("Enter description: ");
        String description = calendar.setDescription(scanner.nextLine());

        var request = new AddCalendarRequest();
        request.setEventDate(eventDate);
        request.setDescription(description);
        System.out.println("Successfully saved: " + request);
        var response = calendarService.add(request);
        System.out.println("Sending response: " + response);
        System.out.println(calendarService.findAll());
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
