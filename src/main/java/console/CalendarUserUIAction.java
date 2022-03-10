package console;

import core.service.CalendarService;
import dto.request.AddCalendarRequest;

import java.util.Scanner;

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
