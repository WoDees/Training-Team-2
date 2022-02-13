package firstlesson;

import java.util.Scanner;

public class Notes {
    public static void main(String[] args) {
        Scanner userNotes = new Scanner(System.in);

        String title;
        System.out.print("Title: ");
        title = userNotes.next();

        String notes;
        System.out.println("Description: ");
        notes = userNotes.next();

        String placeTitle;
        placeTitle = title;
        String placeNotes;
        placeNotes = notes;

        System.out.println(placeTitle);
        System.out.println(placeNotes);
    }
}
