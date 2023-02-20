import java.util.*;
import java.util.stream.Collectors;

public class Main {
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
        System.out.println(relationshipMap);

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

// 2 1 3 7 9 8 6 5 4
// 2 1 3 7 9 8 6 5 4 без шансов 1 2
//круг замыкается в любом случае, когда он верен? нет.
/*
List<Integer> sortedSantaList = santaList.stream().sorted().collect(Collectors.toList());

        List<Integer> toHimselfList = new ArrayList<>();
        Set<Integer> notInSantaList = new TreeSet<>();
        List<Integer> duplicates = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < santaList.size(); i++) {
            //сам себе
            if (santaList.get(i) == i + 1)
                toHimselfList.add(i + 1);

            //нехватающие
            if (sortedSantaList.get(i) != i + 1 + count) {
                if (i != 0 && sortedSantaList.get(i) == sortedSantaList.get(i-1))
                    count--;
                while (sortedSantaList.get(i) != i + 1 + count) {
                    notInSantaList.add(i + 1 + count);
                    count++;
                }
            }

            //дубликаты
            if (i + 1 != santaList.size() && sortedSantaList.get(i) == sortedSantaList.get(i + 1)) {
                duplicates.add(sortedSantaList.get(i));
            }
        }

        if (toHimselfList.size() == 1 && notInSantaList.isEmpty() && duplicates.isEmpty())


        System.out.println("-1 -1");
 */