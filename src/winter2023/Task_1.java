package winter2023;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < sum; i++) {
            String letters = scanner.nextLine();
            if (letters.length() != 7) {
                System.out.println("No");
                continue;
            }

            letters = letters.replace("T", "");
            letters = letters.replace("I", "");
            letters = letters.replace("N", "");
            letters = letters.replace("K", "");
            letters = letters.replace("O", "");
            letters = letters.replace("F", "");
            letters = letters.replace("F", "");

            if (letters.isBlank()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
