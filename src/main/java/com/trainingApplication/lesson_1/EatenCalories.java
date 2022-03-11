package com.trainingApplication.lesson_1;

import java.util.Scanner;

public class EatenCalories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Calories eaten for breakfast: ");
        int breakfast = scanner.nextInt();
        System.out.print("Calories eaten for lunch: ");
        int lunch = scanner.nextInt();
        System.out.print("Calories eaten for dinner: ");
        int dinner = scanner.nextInt();
        System.out.print("Calories eaten at first snack: ");
        int firstSnack = scanner.nextInt();
        System.out.print("Calories eaten at second snack: ");
        int secondSnack = scanner.nextInt();
        System.out.print("Calories eaten at third snack: ");
        int thirdSnack = scanner.nextInt();
        System.out.print("Calories eaten per day: " + (breakfast+lunch+dinner+firstSnack+secondSnack+thirdSnack));
    }
}
