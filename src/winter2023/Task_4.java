package winter2023;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int changesCount = array[1];
        String[] nums = scanner.nextLine().split(" ");

        List<Integer> profits = new ArrayList<>();
        for (String num : nums) {
            int size = num.length();
            String[] numerals = num.split("");
            for (int i = 0; i < size; i++) {
                int profit = (9 - Integer.parseInt(numerals[size - 1 - i])) *  (int) Math.pow(10, i);
                profits.add(profit);
            }
        }

        System.out.println(profits.stream()
                .sorted(Collections.reverseOrder())
                .limit(changesCount)
                .mapToLong(Integer::longValue)
                .sum());
    }
}