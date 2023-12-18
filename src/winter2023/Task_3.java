package winter2023;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gifts = scanner.nextInt();
        int credit = scanner.nextInt();
        int[] costs = new int[gifts];

        int bestBalance = 0;

        for (int i = 0; i < gifts; i++) {
            costs[i] = scanner.nextInt();
        }

        for (int cr = 1; cr <= credit; cr++) {
            int balance = cr;
            for (int i = 0; i < costs.length; i++) {
                if (balance >= costs[i])
                    balance -= costs[i];
            }
            bestBalance = Math.max(bestBalance, balance);
        }

        System.out.println(bestBalance);
    }
}
