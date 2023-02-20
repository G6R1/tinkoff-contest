import java.util.*;

public class test {
    public static void main(String[] args) {
        List<Integer> santaList = new ArrayList<>();
        santaList.add(2);
        santaList.add(5);
        santaList.add(2);
        santaList.add(3);
        santaList.add(4);


//        System.out.println(santaList);
//        System.out.println(relationshipMap);
//        System.out.println(stWithoutRelship);
//        System.out.println(stWithDoubleRelship);
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