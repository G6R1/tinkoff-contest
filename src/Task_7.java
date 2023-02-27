import java.util.*;
import java.util.stream.Collectors;

public class Task_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        scanner.nextLine();
        List<Integer> santaList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (cycleCheck(santaList)) {
            System.out.println("-1 -1");
            System.exit(0);
        }

        Map<Integer, List<Integer>> relationshipMap = new HashMap<>();
        for (int i = 0; i < santaList.size(); i++) {
            relationshipMap.put(i + 1, new ArrayList<>());
        }

        for (int i = 0; i < santaList.size(); i++) {
            relationshipMap.get(santaList.get(i)).add(i + 1);
        }

        List<Integer> stWithoutRelship = new ArrayList<>();
        List<Integer> stWithDoubleRelship = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : relationshipMap.entrySet()) {
            if (entry.getValue().isEmpty()) {
                stWithoutRelship.add(entry.getKey());
            }
            if (entry.getValue().size() == 2) {
                stWithDoubleRelship.add(entry.getValue().get(0));
                stWithDoubleRelship.add(entry.getValue().get(1));
            }
        }

        if (!(stWithoutRelship.size() == 1 && stWithDoubleRelship.size() == 2)){
            System.out.println("-1 -1");
            System.exit(0);
        }

        int save = santaList.get(stWithDoubleRelship.get(0) - 1);
        santaList.set(stWithDoubleRelship.get(0) - 1, stWithoutRelship.get(0));
        if (cycleCheck(santaList)){
            System.out.println(stWithDoubleRelship.get(0) + " " + stWithoutRelship.get(0));
            System.exit(0);
        }

        santaList.set(stWithDoubleRelship.get(0) - 1, save);
        santaList.set(stWithDoubleRelship.get(1) - 1, stWithoutRelship.get(0));
        if (cycleCheck(santaList)){
            System.out.println(stWithDoubleRelship.get(1) + " " + stWithoutRelship.get(0));
            System.exit(0);
        }

        System.out.println("-1 -1");
    }

    private static boolean cycleCheck(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        int num = 1;

        for (int i = 0; i < list.size(); i++) {
            num = list.get(num - 1);
            set.add(num);
        }

        return list.size() == set.size();
    }
}

/**
 * В школе перед Новым Годом устраивают игру в Тайного Санту. Каждому ученику i выдается ученик Ai, которому он
 * должен подарить подарок.
 * Костя, как администратор игры, определил каждому школьнику свое число Ai.
 * Но потом его коллега Маша спросила: А правда ли, что если начать цепочку подарков от школьника 1 к школьнику А1,
 * потом Аа1 и так далее, то цепочка замкнется на школьнике 1, после того, как задействует всех остальных учеников
 * ровно по одному разу?
 * Костя не знает, правда это или нет, но он собирается изменить ровно одно число Аi, чтобы получить конфигурацию,
 * которая устроит Машу. Помогите ему с этим.
 *
 *
 *
 * Формат входных данных
 *
 * В первой строке находится натуральное число n — количество школьников (2 <= n <= 10^5).
 * В следующей строке находится n натуральных чисел Аi — ученик, который достался Тайному Санте с
 * номером i (1 <= Ai <= n).
 *
 *
 *
 * Формат выходных данных
 *
 * В первой строке выведите два числа(1 <= x, y <= n, x != y) — номер ученика x, которому нужно изменить число Ax,
 * и новое значение Ax.
 *
 * Должно выполняться условие Ax != y. Если ответов несколько — выведите любой.
 *
 * Если сделать это невозможно — выведите "−1 −1"
 */