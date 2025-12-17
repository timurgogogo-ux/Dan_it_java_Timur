package java_core_home_work_11;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        String dataFile = "families.dat";
        FileFamilyDao dao = new FileFamilyDao(dataFile);
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            String cmd = sc.nextLine().trim();
            try {
                switch (cmd) {
                    case "1":
                        controller.fillTestData();
                        System.out.println("Test families created.");
                        break;
                    case "2":
                        controller.displayAllFamilies();
                        break;
                    case "3":
                        System.out.print("Number of members >: ");
                        int gt = Integer.parseInt(sc.nextLine());
                        List<Family> greater = controller.getFamiliesBiggerThan(gt);
                        for (Family f : greater) System.out.println(f.prettyFormat());
                        break;
                    case "4":
                        System.out.print("Number of members <: ");
                        int lt = Integer.parseInt(sc.nextLine());
                        List<Family> less = controller.getFamiliesLessThan(lt);
                        for (Family f : less) System.out.println(f.prettyFormat());
                        break;
                    case "5":
                        System.out.print("Number of members =: ");
                        int eq = Integer.parseInt(sc.nextLine());
                        System.out.println("Count: " + controller.countFamiliesWithMemberNumber(eq));
                        break;
                    case "6":
                        createFamily(controller, sc);
                        break;
                    case "7":
                        System.out.print("Family ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        if (controller.deleteFamilyByIndex(id - 1)) System.out.println("Family deleted.");
                        else System.out.println("Invalid ID.");
                        break;
                    case "8":
                        editFamily(controller, sc);
                        break;
                    case "9":
                        System.out.print("Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        controller.deleteAllChildrenOlderThen(age);
                        System.out.println("Children older than " + age + " removed.");
                        break;
                    case "10":
                        service.saveToFileIfPossible();
                        System.out.println("Data saved to file (" + dataFile + ").");
                        break;
                    case "11":
                        service.loadFromFileIfPossible();
                        System.out.println("Data loaded from file (" + dataFile + ").");
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            } catch (FamilyOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Program finished.");
    }

    private static void printMenu() {
        System.out.println("\nCommands:");
        System.out.println("1 - Fill test families");
        System.out.println("2 - Display all families");
        System.out.println("3 - Families bigger than N");
        System.out.println("4 - Families less than N");
        System.out.println("5 - Count families with N members");
        System.out.println("6 - Create new family");
        System.out.println("7 - Delete family");
        System.out.println("8 - Edit family (born/adopt)");
        System.out.println("9 - Delete children older than age");
        System.out.println("10 - Save data to file");
        System.out.println("11 - Load data from file");
        System.out.println("Type 'exit' to quit");
        System.out.print("Enter command: ");
    }

    private static void createFamily(FamilyController controller, Scanner sc) {
        try {
            System.out.print("Mother's first name: "); String mName = sc.nextLine();
            System.out.print("Mother's last name: "); String mSurname = sc.nextLine();
            System.out.print("Mother's year: "); int mY = Integer.parseInt(sc.nextLine());
            System.out.print("Mother's month: "); int mM = Integer.parseInt(sc.nextLine());
            System.out.print("Mother's day: "); int mD = Integer.parseInt(sc.nextLine());
            System.out.print("Mother's IQ: "); int mIq = Integer.parseInt(sc.nextLine());

            System.out.print("Father's first name: "); String fName = sc.nextLine();
            System.out.print("Father's last name: "); String fSurname = sc.nextLine();
            System.out.print("Father's year: "); int fY = Integer.parseInt(sc.nextLine());
            System.out.print("Father's month: "); int fM = Integer.parseInt(sc.nextLine());
            System.out.print("Father's day: "); int fD = Integer.parseInt(sc.nextLine());
            System.out.print("Father's IQ: "); int fIq = Integer.parseInt(sc.nextLine());

            long birthMother = LocalDate.of(mY, mM, mD).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            long birthFather = LocalDate.of(fY, fM, fD).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

            controller.createNewFamily(new Woman(mName, mSurname, birthMother, mIq),
                    new Man(fName, fSurname, birthFather, fIq));
            System.out.println("Family created!");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    private static void editFamily(FamilyController controller, Scanner sc) {
        try {
            System.out.print("Family ID: "); int id = Integer.parseInt(sc.nextLine());
            List<Family> families = controller.getAllFamilies();
            if (id - 1 < 0 || id - 1 >= families.size()) {
                System.out.println("Invalid ID.");
                return;
            }
            Family f = families.get(id - 1);

            System.out.println("1 - Born a child");
            System.out.println("2 - Adopt a child");
            System.out.println("3 - Return");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Boy's name: "); String male = sc.nextLine();
                System.out.print("Girl's name: "); String female = sc.nextLine();
                controller.bornChild(f, male, female);
                System.out.println("Child born!");
            } else if (choice == 2) {
                System.out.print("Child's first name: "); String cName = sc.nextLine();
                System.out.print("Child's last name: "); String cSurname = sc.nextLine();
                System.out.print("Year of birth: "); int y = Integer.parseInt(sc.nextLine());
                System.out.print("Month of birth: "); int m = Integer.parseInt(sc.nextLine());
                System.out.print("Day of birth: "); int d = Integer.parseInt(sc.nextLine());
                System.out.print("IQ: "); int iq = Integer.parseInt(sc.nextLine());
                long birth = LocalDate.of(y, m, d).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
                controller.adoptChild(f, new Human(cName, cSurname, birth, iq));
                System.out.println("Child adopted!");
            } else if (choice == 3) {
                System.out.println("Returning to main menu");
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
