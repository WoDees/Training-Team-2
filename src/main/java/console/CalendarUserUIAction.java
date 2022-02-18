package console;

import core.CalendarService;
import domain.CalendarEntity;

import java.util.Scanner;

public class CalendarUserUIAction implements UIAction {


    private final CalendarService calendarService;

    public CalendarUserUIAction(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Override
    public void execute(Long userId) {
        CalendarEntity calendar = new CalendarEntity();

        System.out.println("Enter date (format dd.mm.yyyy): ");
        Scanner scanner = new Scanner(System.in);
        calendar.setEventDate(scanner.nextLine());
        System.out.println("Enter description: ");
        calendar.setDescription(scanner.nextLine());

        calendar.setUserId(userId);
        calendarService.add(calendar);
        System.out.println(calendarService.findAll());
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
