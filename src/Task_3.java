import java.util.Arrays;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = array[0];
        int timeLimit = array[1];
        int[] floors = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int empNum = scanner.nextInt();

        int timeLimitFloor = floors[empNum - 1];
        int maxFloor = floors[num - 1];
        int minFloor = floors[0];

        int maxToLimit = maxFloor - timeLimitFloor;
        int minToLimit = timeLimitFloor - minFloor;

        if (maxFloor - timeLimitFloor <= timeLimit || timeLimitFloor - minFloor <= timeLimit) {
            System.out.println(maxFloor - minFloor);
        } else if (maxToLimit > minToLimit) {
            System.out.println(minToLimit * 2 + maxToLimit);
        } else {
            System.out.println(maxToLimit * 2 + minToLimit);
        }
    }
}
