import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {
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

            routesClone.forEach((key, value) -> value.removeIf(route -> {
                System.out.println(route.getLength() + " <= " + check + " = " + (route.getLength() <= check));
                return route.getLength() <= check;
            }));
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

    static int statesCount(int citiesNum, Map<Integer, List<Route>> map) { //тут неверный подсчет
        int count = 0;
        Set<Integer> citiesIndices = IntStream.rangeClosed(1, citiesNum).boxed().collect(Collectors.toSet());
        Queue<Integer> queue = new ArrayDeque<>();

        while (!citiesIndices.isEmpty()) {
            queue.add(citiesIndices.iterator().next()); //что если первый элеемент является конечной точкой. от него не идет пути, но идет к нему
            citiesIndices.remove(queue.peek());
            while (!queue.isEmpty()) {
                List<Route> list = map.get(queue.poll());
                if (list != null) {
                    list.forEach(x -> {
                        if (citiesIndices.contains(x.getTo())) {
                            queue.add(x.getTo());
                        }
                        citiesIndices.remove(x.getTo());
                    });
                }
            }
            count++;
        }
        return count;
    }
}
/*
8 9
1 2 15
2 3 10
3 4 20
4 1 25
4 3 60
5 6 40
6 6 20
7 8 10
8 7 50

2 2
1 2 20
2 1 5
 */