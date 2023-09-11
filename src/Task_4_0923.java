import java.util.*;

public class Task_4_0923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int arraySizeX2 = arraySize * 2;
        //нормальный массив?
        int[][] matrix = new int[arraySize * 2][arraySize * 2];
        //допустим, входные данные отсортированы. если нет, сначала сортируем массив, а потом преобразуем в матрицу

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

        int[][] testMatrix = new int[6][6];
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix.length; j++) {
                testMatrix[i][j] = i + j;
            }
        }
        System.out.println(Arrays.deepToString(testMatrix).replace("], ", "]\n"));

        int[][] newMatrix = remoteLineAndColumn(testMatrix, 5, 0);
        System.out.println(Arrays.deepToString(newMatrix).replace("], ", "]\n"));


        List<Integer> result = new ArrayList<>();
        inDepth(matrix, 0, sum, result);

        if (result.size() != 0) {
            System.out.println(result.size());
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static void inDepth(int[][] matrix, int startValue, int sum, List<Integer> result) { //пустой массив, если ответа нет


        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {



                if (startValue + matrix[i][j] > sum) {
                    result.clear();
                    break;
                } else if (startValue + matrix[i][j] == sum) {
                    result.add(matrix[i][j]);
                    break;
                } else if (startValue + matrix[i][j] < sum) {
                    result.add(matrix[i][j]);
                    inDepth(remoteLineAndColumn(matrix, i, j), startValue + matrix[i][j], sum, result);
                }

                

            }
        }
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
 */