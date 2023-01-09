import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        long min = Long.parseLong(array[0]);
        long max = Long.parseLong(array[1]);

        List<Long> interestNums = new ArrayList<>();

        for (long i = 1; i < 10; i++) {
            long num = i;
            for (int j = 0; j < 18; j++){
                interestNums.add(num);
                num = 10 * num + i;
            }
        }

        System.out.println((int) interestNums.stream().filter(x -> x >= min && x <= max).count());
    }
}
