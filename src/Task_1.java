import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if (d - b > 0)
            sum += (d - b) * c;
        System.out.println(sum);
    }
}

/**
 * Костя подключен к мобильному оператору «Мобайл». Абонентская плата Кости составляет A рублей в месяц.
 * За эту стоимость Костя получает B мегабайт интернет-трафика.
 * Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему C рублей.
 * Костя планирует потратить D мегабайт интернет-трафика в следующий месяц.
 * Помогите ему сосчитать, во сколько рублей ему обойдется интернет.
 *
 *
 * Формат входных данных
 *
 * Вводится 4 целых положительных числа A, B, C, D (1 <= A, B, C, D <= 100) — стоимость тарифа Кости, размер
 * тарифа Кости, стоимость каждого лишнего мегабайта, размер интернет-трафика Кости в следующем месяце.
 * Числа во входном файле разделены пробелами.
 *
 * Выведите одно натуральное число — суммарные расходы Кости на интернет.
 */


//        Scanner scanner = new Scanner(System.in);
//        int sum = scanner.nextInt();
//        int arraySize = scanner.nextInt();
//        int[] denominations = new int[arraySize * 2];
//
//        for (int i = 0; i < arraySize * 2; i = i + 2) {
//            denominations[i] = scanner.nextInt();
//            denominations[i + 1] = denominations[i];
//        }
//
//        StringBuilder result = new StringBuilder();
//        int currentSum = sum;
//        for (int i = denominations.length - 1; i >= 0; i--) {
//            if (denominations[i] > currentSum)
//                continue;
//
//            currentSum -= denominations[i];
//
//        }
//
//
//        for (int i = 0; i < denominations.length + 1; i++) {
//
//        }
//
//
//        //размер массива до 10 чисел  //до 20 купюр //попарно купюры %2  1 1 3 3 6 6
//
//
//        System.out.println("кол-во номиналы");
//
//        System.out.println(-1);
//    }

//    int sum(int[] array, int currentSum, String result) {
//        for (int i = ; i < array.length + 1; i++) {
//            ;
//        }
//
//        return 0;
//    }