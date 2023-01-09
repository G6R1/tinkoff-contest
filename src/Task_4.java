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

/**
 * У Кости есть бумажка, на которой написано n чисел. Также у него есть возможность не больше, чем k раз, взять любое
 * число с бумажки, после чего закрасить одну из старых цифр, а на ее месте написать новую произвольную цифру.
 * На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?
 *
 * Формат входных данных
 *
 * В первой строке входного файла даны два целых числа n,k — количество чисел на бумажке и ограничение на число операций.
 * (1 <= n <= 1000, 1 <= k <= 10^4).
 *
 * Во второй строке записано n чисел a_i — числа на бумажке (1 <= a_i <= 10^9)
 *
 * Формат выходных данных
 * В выходной файл выведите одно число — максимальную разность между конечной и начальной суммой.

 * Обратите внимание, что ответ может превышать вместимость 32-битного типа данных.
 */