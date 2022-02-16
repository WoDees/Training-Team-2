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
        System.out.println("Please enter a training days when you want to practice : ");
        System.out.println("1) Monday to Wednesday");
        System.out.println("2) Thursday to Saturday");
        System.out.println("3) Friday to Sunday");
        System.out.println("4) All week");
        int trainingDays = scanner.nextInt();

        if (trainingDays == 1) {
            System.out.println("Monday,Tuesday,Wednesday");
        } else if (trainingDays == 2) {
            System.out.println("Thursday,Friday,Saturday");
        } else if (trainingDays == 3) {
            System.out.println("Friday,Saturday,Sunday");
        } else if (trainingDays == 4) {
            System.out.println("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday");
        } else {
            System.out.println("Invalid Data");
        }

        UserEntity userTrainingDays = new UserEntity();
        userTrainingDays.setTrainingDay(trainingDays);
        calendarService.add(userTrainingDays);
        calendarService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
