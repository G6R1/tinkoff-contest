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

/**
 * У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам. Все встре- чи происходят на разных
 * этажах, а между этажами можно перемещаться только по лестничным пролетам — считается, что это улучшает физическую
 * форму сотрудников. Прохождение каждого пролета занимает ровно 1 минуту.
 * Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке, но один из них
 * покинет офис через t минут. С парковочного этажа лестницы нет — только лифт, на котором можно подняться на любой этаж.
 *
 * В итоге план Кати следующий:
 * Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за 0 минут.
 * Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются
 * мгновенно.
 * В первые t минут передать договор тому коллеге, который планирует уйти.
 * Пройти минимальное количество лестничных пролетов.
 * Помогите Кате выполнить все пункты ее плана.
 *
 * Формат входных данных
 *
 * В первой строке вводятся целые положительные числа n и t (2 <= n,t <= 100) — количество сотрудников и время,
 * когда один из сотрудников покинет офис (в минутах). В следующей строке n чисел — номера этажей, на которых
 * находятся сотрудники. Все числа различны и по абсолютной величине не превосходят 100. Номера этажей даны в порядке
 * возрастания. В следующей строке записан номер сотрудника, который уйдет через t минут.
 *
 * Формат выходных данных
 *
 * Выведите одно число — минимально возможное число лестничных пролетов, которое понадобится пройти Кате.
 */