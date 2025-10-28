package java_core_home_worke_3;

import java.util.Scanner;

public class java_core_home_worke_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";    schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";    schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";   schedule[2][1] = "buy groceries";
        schedule[3][0] = "Wednesday"; schedule[3][1] = "gym workout";
        schedule[4][0] = "Thursday";  schedule[4][1] = "meet friends";
        schedule[5][0] = "Friday";    schedule[5][1] = "study for exam";
        schedule[6][0] = "Saturday";  schedule[6][1] = "relax and read";

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            boolean found = false;
            String standardizedInput = input.toLowerCase();

            for (int i = 0; i < schedule.length; i++) {
                if (schedule[i][0].toLowerCase().equals(standardizedInput)) {
                    System.out.println("Your tasks for " + schedule[i][0] + ": " + schedule[i][1] + ".");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

        System.out.println("Program terminated. Goodbye!");
        scanner.close();
    }
}