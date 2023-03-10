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

/**
 * Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать
 * рулет на N равных частей. Разумеется, рулет можно резать только поперек. Соотвественно, Костя сделает N - 1
 * разрез ножом через равные промежутки.
 *По возвращению с кофе-брейка Ваня задумался — а можно ли было обойтись меньшим числом движений, будь нож Вани
 * бесконечно длинным (иначе говоря, если он мог бы сделать сколько угодно разрезов за раз, если эти разрезы лежат
 * на одной прямой)? Считается, что места для разрезов намечены заранее, и все разрезы делаются с ювелирной точностью.
 *Оказывается, что можно. Например, если Ваня хотел бы разделить рулет на 4 части, он мог бы обойтись двумя
 * разрезами — сначала он разделил бы рулет на две половинки, а потом совместил бы две половинки и разрезал обе
 * пополам одновременно.
 *Вам дано число N, требуется сказать, каким минимальным числом разрезов можно обойтись.
 *
 * Формат входных данных
 *
 * Дано одно натуральное число N(1 <= N <= 2*10^9) — количество людей на кофе-брйке.
 *
 * Формат выходных данных
 *
 * Выведите одно число — минимальное число движений, которое придется сделать Косте.
 */