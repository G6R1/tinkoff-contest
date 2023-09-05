import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int citiesNum = scanner.nextInt();
        int roadsNum = scanner.nextInt();
        Map<Integer, List<Route>> routes = new HashMap<>();
        int minLenght = 1000000000;
        int maxLenght = 0;

        for (int i = 0; i < roadsNum; i++) {
            int from = scanner.nextInt();

            if (!routes.containsKey(from))
                routes.put(from, new ArrayList<>());

            int to = scanner.nextInt();
            int length = scanner.nextInt();
            routes.get(from).add(new Route(to, length));

            if (length > maxLenght)
                maxLenght = length;
            if (length < minLenght)
                minLenght = length;
        }

        int oldStates = statesCount(citiesNum, routes);

        while (true) {
            if (maxLenght - 1 == minLenght) {
                System.out.println(minLenght);
                return;
            }

            int check = (maxLenght + minLenght) / 2;
            Map<Integer, List<Route>> routesClone = new HashMap<Integer,List<Route>>(routes);
            routesClone.forEach((key, value) -> value.removeIf(route -> route.getLength() <= check));
            int newStates = statesCount(citiesNum, routesClone);
            if (newStates < oldStates) {
                maxLenght -= maxLenght - check;
            } else {
                minLenght += check - minLenght;
            }
        }
    }

    static class Route {
        private int to;
        private int length;

        public Route(int to, int length) {
            this.to = to;
            this.length = length;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    static int statesCount(int citiesNum, Map<Integer, List<Route>> map) {
        int count = 0;
        Set<Integer> citiesIndices = IntStream.rangeClosed(1 , citiesNum).boxed().collect(Collectors.toSet());
        Queue<Integer> queue = new ArrayDeque<>();

        while (!citiesIndices.isEmpty()) {
            queue.add(citiesIndices.iterator().next());
            citiesIndices.remove(queue.peek());
            while (!queue.isEmpty()) {
                if (map.get(queue.peek()) == null){
                    queue.poll();
                    continue;
                }
                map.get(queue.poll())
                        .forEach(x -> {
                            if (citiesIndices.contains(x.getTo())) {
                                queue.add(x.getTo());
                            }
                            citiesIndices.remove(x.getTo());
                        });
            }
            count++;
        }
        return count;
    }
}