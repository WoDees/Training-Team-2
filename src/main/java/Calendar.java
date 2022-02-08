import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

class Calendar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a month between 1 and 12 (e.g. 7): ");
        int month = scanner.nextInt();

        System.out.print("Please enter a full year (e.g. 2022): ");
        int year = scanner.nextInt();
        printMonth(year, month);
    }

    static void printMonth(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int counter = 1;

        int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        if (dayValue != 7)
            for (int i = 0; i < dayValue; i++, counter++) {
                System.out.printf("%-4s", "");
            }

        for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
            System.out.printf("%-4d", i);

            if (counter % 7 == 0) {
                System.out.println();
            }
        }
    }
}
