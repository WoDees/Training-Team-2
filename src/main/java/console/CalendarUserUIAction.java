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
        int trainingDays;
        do {
            System.out.println("Enter the number of the day of the week (1-7) to select training days, if you wanna Finish selection press number(8): ");
            trainingDays = scanner.nextInt();

            switch (trainingDays) {
                case 1 -> System.out.println("Monday");
                case 2 -> System.out.println("Tuesday");
                case 3 -> System.out.println("Wednesday");
                case 4 -> System.out.println("Thursday");
                case 5 -> System.out.println("Friday");
                case 6 -> System.out.println("Saturday");
                case 7 -> System.out.println("Sunday");
                case 8 -> System.out.println("Finish selection");
                default -> System.out.println("Invalid Day");
            }
        } while (trainingDays != 8);

        UserEntity userTrainingDays = new UserEntity();
        userTrainingDays.setTrainingDayAmount(trainingDays);
        calendarService.saveTrainingDays(userTrainingDays);
        calendarService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getActionName() {
        return "Training calendar";
    }
}
