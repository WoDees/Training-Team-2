package com.trainingApplication.lesson_1;

import java.util.Scanner;

class DayEdits {

    public static void main(String[] args) {

        System.out.println("""
                1 - Running (8km/h)
                2 - Running (10km/h)
                3 - Running (16 km/h)
                4 - Walking (6km/h)
                5 - Swimming (2,4km/h)
                6 - Jumping rope
                7 - Stretching
                8 - Workout in the gym
                9 - High intensity dancing
                10 - Football
                11 - Basketball
                12 - Tennis
                13 - Volleyball
                14 - Skiing
                15 - Cycling (14km/h)
                Please enter the number of your activity:\s""");
        Scanner scanner = new Scanner(System.in);
        int activity = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("You want to change your activity?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int changeActivity = scanner1.nextInt();

        if (changeActivity == 1) {
            System.out.println("Please choose new activity!");
            System.out.println("""
                    1 - Running (8km/h)
                    2 - Running (10km/h)
                    3 - Running (16 km/h)
                    4 - Walking (6km/h)
                    5 - Swimming (2,4km/h)
                    6 - Jumping rope
                    7 - Stretching
                    8 - Workout in the gym
                    9 - High intensity dancing
                    10 - Football
                    11 - Basketball
                    12 - Tennis
                    13 - Volleyball
                    14 - Skiing
                    15 - Cycling (14km/h)
                    Please enter the number of your activity:\s""");
            activity = scanner.nextInt();
            System.out.print("How much time did you spend on your activity (min): ");

        } else if (changeActivity == 2) {
            System.out.print("How much time did you spend on your activity (min): ");
        }

        int time = scanner.nextInt();
        double result = switch (activity) {
            case (1), (14), (9), (12) -> 8.08 * time;
            case (2) -> 10.5 * time;
            case (3) -> 12.5 * time;
            case (4) -> 4.5 * time;
            case (5) -> 7.66 * time;
            case (6) -> 9 * time;
            case (7) -> 2.1 * time;
            case (8) -> 8.66 * time;
            case (10) -> 7.5 * time;
            case (11) -> 6.33 * time;
            case (13) -> 4.25 * time;
            case (15) -> 5 * time;
            default -> 0;
        };
        System.out.println(result + "ccal");
    }
}