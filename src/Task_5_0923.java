import java.util.*;

public class Task_5_0923 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesNum = scanner.nextInt();
        int roadsNum = scanner.nextInt();
        Map<Integer, List<Route>> routes = new HashMap<>();
        int minLength = 1000000000;
        int maxLength = 0;

        for (int i = 0; i < roadsNum; i++) {
            int from = scanner.nextInt();

            if (!routes.containsKey(from))
                routes.put(from, new ArrayList<>());

            int to = scanner.nextInt();
            int length = scanner.nextInt();
            if (to != from) //убираем дороги из города в тот же самый город. случай,когда ВСЕ дроги такие, невозможен по условию
                routes.get(from).add(new Route(to, length));

            if (length > maxLength)
                maxLength = length;
            if (length < minLength)
                minLength = length;
        }

        int oldStates = statesCount(citiesNum, routes);

        while (true) {
            if (maxLength == minLength) {
                System.out.println(minLength);
                return;
            }

            int check = minLength + (maxLength - minLength) / 2 + 1;
            Map<Integer, List<Route>> routesClone = new HashMap<>();
            for (Map.Entry<Integer, List<Route>> entry : routes.entrySet()) {
                routesClone.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            routesClone.forEach((key, value) -> value.removeIf(route -> route.getLength() <= check));

            int newStates = statesCount(citiesNum, routesClone);

            if (newStates > oldStates) {
                maxLength = check - 1;
            } else {
                minLength = check;
            }
        }
    }

    static class Route {
        private final int to;
        private final int length;

        public Route(int to, int length) {
            this.to = to;
            this.length = length;
        }

        public int getTo() {
            return to;
        }

        public int getLength() {
            return length;
        }
    }

    static int statesCount(int citiesNum, Map<Integer, List<Route>> map) {

        Map<Integer, Set<Integer>> connections = new HashMap<>();
        for (int i = 1; i <= citiesNum; i++) {
            connections.put(i, new HashSet<>());
        }

        //город - [все города, в которые из него можно попасть, включая самого себя]
        for (Map.Entry<Integer, List<Route>> entry: map.entrySet()) {
            for (Route route: entry.getValue()) {
                int from = entry.getKey();
                int to = route.getTo();
                connections.get(from).addAll(connections.get(to));
                connections.get(from).add(to);
                connections.get(to).addAll(connections.get(from));
                connections.get(to).add(from);
            }
        }

        Set<Integer> forRemove = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry: connections.entrySet()){
            if (!forRemove.contains(entry.getKey())) {
                forRemove.addAll(entry.getValue());
                forRemove.remove(entry.getKey()); //убираем из списка номер города from
            }
        }

        for (Integer num: forRemove) {
            connections.remove(num);
        }

        return connections.size();
    }
}
/*
ответ 24
8 9
1 2 17
2 3 25
3 4 30
4 1 25
4 3 60
5 6 40
6 6 20
7 8 10
8 7 50

ответ 19
2 2
1 2 20
2 1 5

ответ 4
5 7
1 2 5
1 1 2
3 4 4
2 3 7
3 3 20
4 1 10
5 5 100
 */