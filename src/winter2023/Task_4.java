package winter2023;

import java.util.*;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int treeSize = scanner.nextInt();
        int companies = scanner.nextInt();
        scanner.nextLine();
        Set<String> companiesNames = new HashSet<>();

        int[] parents = new int[treeSize];
        int[] costs = new int[treeSize];
        String[] companiesInNodes = new String[treeSize];

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < companies; i++) {
            companiesNames.add(scanner.nextLine());
        }

        for (int i = 0; i < treeSize; i++) {
            parents[i] = scanner.nextInt() - 1;
            costs[i] = scanner.nextInt();
            companiesInNodes[i] = scanner.nextLine().trim();
        }

        for (int i = treeSize - 1; i >= 0; i--) {
            minCost = Math.min(checkNode(i,
                    parents,
                    costs,
                    companiesInNodes,
                    0,
                    new HashSet<>(companiesNames)), minCost);
        }

        System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
    }

    public static int checkNode(int nodeNumber,
                                int[] parents,
                                int[] costs,
                                String[] companiesInNodes,
                                int currentCost,
                                Set<String> companiesSet) {

        currentCost += costs[nodeNumber];
        companiesSet.remove(companiesInNodes[nodeNumber]);

        if (companiesSet.isEmpty()) {
            return currentCost;
        } else if (parents[nodeNumber] < 0) {
            return Integer.MAX_VALUE;
        } else {
            currentCost += checkNode(parents[nodeNumber],
                    parents,
                    costs,
                    companiesInNodes,
                    currentCost,
                    companiesSet);
        }

        return companiesSet.isEmpty() ? currentCost : Integer.MAX_VALUE;
    }
}
/*
5 2
A
B
0 1 A
1 2 A
1 2 B
1 1 B
4 2 A

 */