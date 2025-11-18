package java_core_home_work_10;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FamilyController controller = new FamilyController(new FamilyService(new CollectionFamilyDao()));

        boolean exit = false;
        while (!exit) {
            printMenu();
            String input = sc.nextLine();
            try {
                if ("1".equals(input)) {
                    controller.fillTestData();
                    System.out.println("Test data filled!");
                } else if ("2".equals(input)) {
                    controller.displayAllFamilies();
                } else if ("3".equals(input)) {
                    System.out.print("Enter minimum number of family members: ");
                    int min = Integer.parseInt(sc.nextLine());
                    controller.getFamiliesBiggerThan(min).forEach(System.out::println);
                } else if ("4".equals(input)) {
                    System.out.print("Enter maximum number of family members: ");
                    int max = Integer.parseInt(sc.nextLine());
                    controller.getFamiliesLessThan(max).forEach(System.out::println);
                } else if ("5".equals(input)) {
                    System.out.print("Enter exact number of family members: ");
                    int exact = Integer.parseInt(sc.nextLine());
                    System.out.println(controller.countFamiliesWithMemberNumber(exact));
                } else if ("6".equals(input)) {
                    System.out.print("Mother's first name: ");
                    String mn = sc.nextLine();
                    System.out.print("Mother's last name: ");
                    String ms = sc.nextLine();
                    System.out.print("Mother's birth year: ");
                    int my = Integer.parseInt(sc.nextLine());
                    System.out.print("Month: ");
                    int mm = Integer.parseInt(sc.nextLine());
                    System.out.print("Day: ");
                    int md = Integer.parseInt(sc.nextLine());
                    System.out.print("Mother's IQ: ");
                    int miq = Integer.parseInt(sc.nextLine());
                    long mbirth = LocalDate.of(my, mm, md).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    Woman mother = new Woman(mn, ms, mbirth, miq);

                    System.out.print("Father's first name: ");
                    String fn = sc.nextLine();
                    System.out.print("Father's last name: ");
                    String fs = sc.nextLine();
                    System.out.print("Father's birth year: ");
                    int fy = Integer.parseInt(sc.nextLine());
                    System.out.print("Month: ");
                    int fm = Integer.parseInt(sc.nextLine());
                    System.out.print("Day: ");
                    int fd = Integer.parseInt(sc.nextLine());
                    System.out.print("Father's IQ: ");
                    int fiq = Integer.parseInt(sc.nextLine());
                    long fbirth = LocalDate.of(fy, fm, fd).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    Man father = new Man(fn, fs, fbirth, fiq);

                    controller.createNewFamily(mother, father);
                    System.out.println("Family created!");
                } else if ("7".equals(input)) {
                    System.out.print("Enter family ID to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (controller.deleteFamilyByIndex(id - 1))
                        System.out.println("Family deleted!");
                    else
                        System.out.println("Invalid ID!");
                } else if ("9".equals(input)) {
                    System.out.print("Enter age to remove children older than: ");
                    int age = Integer.parseInt(sc.nextLine());
                    controller.deleteAllChildrenOlderThen(age);
                    System.out.println("Children older than age removed!");
                } else if ("exit".equals(input)) {
                    exit = true;
                } else {
                    System.out.println("Unknown command!");
                }
            } catch (FamilyOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        sc.close();
        System.out.println("Program terminated.");
    }

    private static void printMenu() {
        System.out.println("\nChoose a command:");
        System.out.println("1. Fill test data");
        System.out.println("2. Display all families");
        System.out.println("3. Families with more members than specified");
        System.out.println("4. Families with fewer members than specified");
        System.out.println("5. Count families with exact number of members");
        System.out.println("6. Create new family");
        System.out.println("7. Delete family by ID");
        System.out.println("9. Remove children older than specified age");
        System.out.println("Enter 'exit' to quit");
        System.out.print("Your command: ");
    }
}
