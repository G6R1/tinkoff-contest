import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        int count = 0;

        while (n > 1) {
            count++;
            n /= 2;
        }

        System.out.println(count);
    }
}