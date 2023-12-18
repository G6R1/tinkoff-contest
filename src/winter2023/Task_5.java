package winter2023;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int childNum = scanner.nextInt();
        int[] childsCounts = new int[childNum];
        int pairsNum = scanner.nextInt();
        Map<Integer, Set<Integer>> friendsPairs = new HashMap<>();
        int eventsNum = scanner.nextInt();

        for (int i = 0; i < childNum; i++) {
            childsCounts[i] = scanner.nextInt();
        }

        for (int i = 0; i < pairsNum; i++) {
            int friendOne = scanner.nextInt();
            int friendTwo = scanner.nextInt();

            if (friendsPairs.containsKey(friendOne)) {
                friendsPairs.get(friendOne).add(friendTwo);
            } else {
                friendsPairs.put(friendOne, new HashSet<>());
                friendsPairs.get(friendOne).add(friendTwo);
            }

            if (friendsPairs.containsKey(friendTwo)) {
                friendsPairs.get(friendTwo).add(friendOne);
            } else {
                friendsPairs.put(friendTwo, new HashSet<>());
                friendsPairs.get(friendTwo).add(friendOne);
            }
        }

        scanner.nextLine();
        for (int i = 0; i < eventsNum; i++) {
            String line = scanner.nextLine();

            if (line.startsWith("?")) {
                System.out.println(childsCounts[Integer.parseInt(line.substring(2)) - 1]);
            }

            if (line.startsWith("+")) {
                String[] split = line.split(" ");
                int sender = Integer.parseInt(split[1]);
                int amount = Integer.parseInt(split[2]);

                for (Integer childNumber: friendsPairs.getOrDefault(sender, new HashSet<>())) {
                    childsCounts[childNumber - 1]  += amount;
                }
            }
        }
    }
}
/*
5 5 5
1 2 3 4 5
1 2
2 3
3 4
4 5
5 1
? 1
? 5
+ 1 2
? 1
? 5

 */