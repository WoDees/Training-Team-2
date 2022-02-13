package lesson_1;

class AverageCalorie {

    void averageCalorie(int weight, int growth, int age) {
        double averageCalorie = 88.36 + (4.8 * weight) + (4.8 * growth) - (5.7 * age);
        System.out.println("Average calorie per day: " + averageCalorie);
        System.out.println("Average calorie per week: " + averageCalorie * 7);
        System.out.println("Average calorie per month: " + averageCalorie * 30);
    }
}
