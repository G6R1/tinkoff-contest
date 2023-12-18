package winter2023;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        int requestsNum = scanner.nextInt();

        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.nextLine();
        for (int i = 0; i < requestsNum; i++) {
            String request = scanner.nextLine();

            if (request.startsWith("?")) {
                String[] split = request.split(" ");
                int start = Integer.parseInt(split[1]);
                int end = Integer.parseInt(split[2]);
                int k = Integer.parseInt(split[3]);
                int b = Integer.parseInt(split[4]);

                int max = Integer.MIN_VALUE;

                for (int j = start - 1; j < end; j++) {
                    int current = Math.min(array[j], k * (j + 1) + b);
                    max = Math.max(max, current);
                }

                System.out.println(max);
            }

            if (request.startsWith("+")) {
                String[] split = request.split(" ");
                int startInclude = Integer.parseInt(split[1]);
                int endInclude = Integer.parseInt(split[2]);
                int increment = Integer.parseInt(split[3]);

                for (int j = startInclude - 1; j < endInclude; j++) {
                    array[j] += increment;
                }
            }
        }
    }
}

/*
6 3
2 4 6 8 10 12
? 2 5 3 0
+ 2 3 6
? 2 5 3 2

 */