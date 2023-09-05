import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int arraySizeX2 = arraySize * 2;
        int[][] matrix = new int[arraySize * 2][arraySize * 2];

        for (int i = 0; i < arraySizeX2; i = i + 2) {
            int value = scanner.nextInt();
            for (int j = 0; j < arraySizeX2; j = j + 2) {
                matrix[i][j] = value;
                matrix[i][j + 1] = value;
                matrix[i + 1][j] = value;
                matrix[i + 1][j + 1] = value;
            }
        }

        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));

        //размер массива до 10 чисел  //до 20 купюр //попарно купюры %2  1 1 3 3 6 6
        System.out.println("кол-во номиналы");
        System.out.println(-1);
    }

    //предмет индекс+значение
}