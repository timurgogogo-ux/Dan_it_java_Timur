package java_core_home_work_10;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        FamilyDao dao = new CollectionFamilyDao();
        FamilyService service = new FamilyService(dao);
        FamilyController controller = new FamilyController(service);

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCommands:\n" +
                    "1-Test families\n" +
                    "2-All families\n" +
                    "3-Families bigger than N\n" +
                    "4-Families less than N\n" +
                    "5-Count families with N members\n" +
                    "6-Create new family\n" +
                    "7-Delete family\n" +
                    "8-Edit family\n" +
                    "9-Delete children older than age\n" +
                    "exit-Exit");
            System.out.print("Enter command: ");
            String cmd = sc.nextLine();

            try {
                if ("1".equals(cmd)) {
                    createTestFamilies(controller);
                } else if ("2".equals(cmd)) {
                    displayAllFamilies(controller);
                } else if ("3".equals(cmd)) {
                    System.out.print("Number of members >: ");
                    int n = Integer.parseInt(sc.nextLine());
                    displayFamilies(controller.getFamiliesBiggerThan(n));
                } else if ("4".equals(cmd)) {
                    System.out.print("Number of members <: ");
                    int n = Integer.parseInt(sc.nextLine());
                    displayFamilies(controller.getFamiliesLessThan(n));
                } else if ("5".equals(cmd)) {
                    System.out.print("Number of members =: ");
                    int n = Integer.parseInt(sc.nextLine());
                    System.out.println("Count: " + controller.countFamiliesWithMemberNumber(n));
                } else if ("6".equals(cmd)) {
                    createFamily(controller, sc);
                } else if ("7".equals(cmd)) {
                    System.out.print("Family ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (dao.deleteFamily(id - 1)) System.out.println("Family deleted.");
                    else System.out.println("Invalid ID.");
                } else if ("8".equals(cmd)) {
                    editFamily(controller, sc);
                } else if ("9".equals(cmd)) {
                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    controller.deleteAllChildrenOlderThen(age);
                    System.out.println("Children older than " + age + " deleted.");
                } else if ("exit".equals(cmd)) {
                    exit = true;
                } else {
                    System.out.println("Unknown command!");
                }
            } catch (FamilyOverflowException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        sc.close();
        System.out.println("Program finished.");
    }

    private static void createTestFamilies(FamilyController controller) {
        long birthMother = LocalDate.of(1985, 3, 10).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long birthFather = LocalDate.of(1980, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        controller.createNewFamily(new Woman("Anna", "Smith", birthMother, 95),
                new Man("John", "Smith", birthFather, 90));
        controller.createNewFamily(new Woman("Kate", "Bibo", birthMother, 90),
                new Man("Karl", "Bibo", birthFather, 85));
        System.out.println("Test families created!");
    }

    private static void displayAllFamilies(FamilyController controller) {
        List<Family> families = controller.getAllFamilies();
        for (int i = 0; i < families.size(); i++) {
            System.out.println((i + 1) + ".\n" + families.get(i).prettyFormat());
        }
    }

    private static void displayFamilies(List<Family> families) {
        for (Family f : families) System.out.println(f.prettyFormat());
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
            Family f = controller.getFamilyById(id - 1);
            if (f == null) { System.out.println("Invalid ID."); return; }

            System.out.println("1-Born a child\n2-Adopt a child\n3-Return");
            System.out.print("Choice: "); int choice = Integer.parseInt(sc.nextLine());

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
