import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        scanner.nextLine();
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> evenOutPlace = new ArrayList<>();
        List<Integer> oddOutPlace = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            if (i % 2 == 1 && array[i] % 2 == 1) {
                oddOutPlace.add(i + 1);
            } else if (i % 2 == 0 && array[i] % 2 == 0) {
                evenOutPlace.add(i + 1);
            }
        }

        if (evenOutPlace.size() == 1 && oddOutPlace.size() == 1) {
            System.out.println(evenOutPlace.get(0) + " " + oddOutPlace.get(0));
        } else {
            System.out.println("-1 -1");
        }
    }
}

//Ответ неполный