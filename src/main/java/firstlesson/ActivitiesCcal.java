package firstlesson;

import java.util.Scanner;

public class ActivitiesCcal {
    public static void main(String[] args) {
        System.out.println("1 - Running (8km/h)" + "\n" +
                "2 - Running (10km/h)" + "\n" +
                "3 - Running (16 km/h)" + "\n" +
                "4 - Walking (6km/h)" + "\n" +
                "5 - Swimming (2,4km/h)" + "\n" +
                "6 - Jumping rope" + "\n" +
                "7 - Stretching" + "\n" +
                "8 - Workout in the gym" + "\n" +
                "9 - High intensity dancing" + "\n" +
                "10 - Football" + "\n" +
                "11 - Basketball" + "\n" +
                "12 - Tennis" + "\n" +
                "13 - Volleyball" + "\n" +
                "14 - Skiing" + "\n" +
                "15 - Cycling (14km/h)" + "\n" +
                "Please enter the number of your activity: ");
        Scanner scanner = new Scanner(System.in);
        int activity = scanner.nextInt();

        System.out.print("How much time did you spend on your activity (min): ");
        int time = scanner.nextInt();
        double result = 0;

        switch (activity) {
            case (1):
                result = 8.08 * time;
                break;
            case (2):
                result = 10.5 * time;
                break;
            case (3):
                result = 12.5 * time;
                break;
            case (4):
                result = 4.5 * time;
                break;
            case (5):
                result = 7.66 * time;
                break;
            case (6):
                result = 9 * time;
                break;
            case (7):
                result = 2.1 * time;
                break;
            case (8):
                result = 8.66 * time;
                break;
            case (9):
                result = 8.08 * time;
                break;
            case (10):
                result = 7.5 * time;
                break;
            case (11):
                result = 6.33 * time;
                break;
            case (12):
                result = 8.08 * time;
                break;
            case (13):
                result = 4.25 * time;
                break;
            case (14):
                result = 8.08 * time;
                break;
            case (15):
                result = 5 * time;
                break;
        }
        System.out.println(result + "ccal");
    }
}
