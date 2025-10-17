package Home_worke_3;

import java.util.Scanner;

public class ScannerExamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age please: ");
        int age = scanner.nextInt();

        System.out.println("Enter your name and surname: ");
        scanner.nextLine();
        String nameSurname = scanner.nextLine();

        System.out.println("Your ag is: " + age);
        System.out.println("Your name is:" + nameSurname);
    }
}
