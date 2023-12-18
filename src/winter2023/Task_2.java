package winter2023;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sets = scanner.nextInt();
        int additionalConnections = 0;

        for (int i = 0; i < sets; i++) {
            int developers = scanner.nextInt();
            //int[] socialities = new int[developers];
            for (int j = 0; j < developers; j++) {
                //socialities[j] = scanner.nextInt();
                additionalConnections += scanner.nextInt() - 1;
            }

            if (additionalConnections >= developers - 2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            additionalConnections = 0;
        }
    }
}
/*
4
1
1000000000
2
1 1
3
1 1 1
4
1 1 2 2

 */