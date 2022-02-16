package console;

import core.CalendarService;
import domain.UserEntity;

import java.util.Scanner;

public class CalendarUserUIAction implements UIAction {

    private final CalendarService calendarService;

    public CalendarUserUIAction(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a weekdays when you want to practice : ");
        System.out.println("1) Monday to Wednesday");
        System.out.println("2) Thursday to Saturday");
        System.out.println("3) Friday to Sunday");
        System.out.println("4) All week");
        int weekdays = scanner.nextInt();
        calendarService.days(weekdays);

        UserEntity newDays = new UserEntity();
        newDays.setAddDays(weekdays);
        calendarService.add(newDays);
        calendarService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
