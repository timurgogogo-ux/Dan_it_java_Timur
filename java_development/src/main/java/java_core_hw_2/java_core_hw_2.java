package java_core_hw_2;

import java.util.Random;
import java.util.Scanner;

public class java_core_hw_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int SIZE = 5;
        char[][] field = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = '-';
            }
        }

        int targetRow = random.nextInt(SIZE);
        int targetCol = random.nextInt(SIZE);

        System.out.println("All Set. Get ready to rumble!");
        System.out.println();

        while (true) {
            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("Enter line (1-5): ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    if (row >= 1 && row <= SIZE) {
                        break;
                    } else {
                        System.out.println("Number must be between 1 and 5!");
                    }
                } else {
                    System.out.println("Please enter a number!");
                    scanner.next();
                }
            }

            while (true) {
                System.out.print("Enter column (1-5): ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    if (col >= 1 && col <= SIZE) {
                        break;
                    } else {
                        System.out.println("Number must be between 1 and 5!");
                    }
                } else {
                    System.out.println("Please enter a number!");
                    scanner.next();
                }
            }


            if (row - 1 == targetRow && col - 1 == targetCol) {
                field[targetRow][targetCol] = 'x';
                System.out.println("\nYou have won!");
                printField(field);
                break;
            } else {
                if (field[row - 1][col - 1] == '-') {
                    field[row - 1][col - 1] = '*';
                } else {
                    System.out.println("You already shot here!");
                }
                System.out.println();
                printField(field);
            }
        }
        scanner.close();
    }

    public static void printField(char[][] field) {
        System.out.print("  | ");
        for (int i = 1; i <= field.length; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();

        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

