package java_core_hw_3_new;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] schedule = createSchedule();

        while (true) {
            System.out.print("Please, input the day of the week: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                break;
            }

            switch (input) {
                case "sunday":
                    System.out.println("Your tasks for Sunday: " + schedule[0][1] + ".");
                    break;
                case "monday":
                    System.out.println("Your tasks for Monday: " + schedule[1][1] + ".");
                    break;
                case "tuesday":
                    System.out.println("Your tasks for Tuesday: " + schedule[2][1] + ".");
                    break;
                case "wednesday":
                    System.out.println("Your tasks for Wednesday: " + schedule[3][1] + ".");
                    break;
                case "thursday":
                    System.out.println("Your tasks for Thursday: " + schedule[4][1] + ".");
                    break;
                case "friday":
                    System.out.println("Your tasks for Friday: " + schedule[5][1] + ".");
                    break;
                case "saturday":
                    System.out.println("Your tasks for Saturday: " + schedule[6][1] + ".");
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
                    break;
            }
        }

        System.out.println("Program terminated. Goodbye!");
        scanner.close();
    }

    // ⬇️ Масив переміщено в окремий метод нижче
    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";    schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";    schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";   schedule[2][1] = "buy groceries";
        schedule[3][0] = "Wednesday"; schedule[3][1] = "gym workout";
        schedule[4][0] = "Thursday";  schedule[4][1] = "meet friends";
        schedule[5][0] = "Friday";    schedule[5][1] = "study for exam";
        schedule[6][0] = "Saturday";  schedule[6][1] = "relax and read";
        return schedule;
    }
}
