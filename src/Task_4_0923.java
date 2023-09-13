import java.util.*;

public class Task_4_0923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int arraySizeX2 = arraySize * 2;
        int[][] matrix = new int[arraySizeX2][arraySizeX2];

        for (int i = 0; i < arraySizeX2; i += 2) {
            int value = scanner.nextInt();
            for (int j = 0; j < arraySizeX2; j += 2) {
                matrix[i][j] = value;
                matrix[i][j + 1] = value;
                matrix[i + 1][j] = value;
                matrix[i + 1][j + 1] = value;
            }
        }

        List<Integer> result = new ArrayList<>();
        recursSumSearch(matrix, 0, sum, result);

        if (result.size() != 0) {
            System.out.println(result.size());
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static void recursSumSearch(int[][] matrix, int startValue, int sum, List<Integer> result) {

            for (int i = 0; i < matrix.length; i++) {
                int checkSum = 0;
                for(Integer integer: result)
                    checkSum += integer;
                if (checkSum == sum)
                    return;
                if (startValue + matrix[i][0] > sum) {
                    result.clear();
                    break;
                } else if (startValue + matrix[i][0] == sum) {
                    result.add(matrix[i][0]);
                    return;
                } else if (startValue + matrix[i][0] < sum) {
                    result.add(matrix[i][0]);
                    recursSumSearch(remoteLineAndColumn(matrix, i, 0), startValue + matrix[i][0], sum, result);
                }
            }
            result.clear();

    }

    private static int[][] remoteLineAndColumn(int[][] matrix, int line, int column) { //отсчет line и column с нуля
        int[][] result = new int[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < line && j < column) {
                    result[i][j] = matrix[i][j];
                } else if (i > line && j > column){
                    result[i - 1][j - 1] = matrix[i][j];
                } else if (i < line && j > column) {
                    result[i][j - 1] = matrix[i][j];
                } else if (i > line && j < column) {
                    result[i - 1][j] = matrix[i][j];
                }
            }
        }

        return result;
    }
}
/*
5 2
1 2

5 4
1 2 3 6

24 4
1 2 3 6

5 3
1 2 3
 */