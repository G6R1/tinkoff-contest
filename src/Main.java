public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(5));


    }

    private static long fibonacciSum(long num) {
        if (num == 1)
            return 1;

        long sum = 1;
        long lastNum = 0;
        long currNum = 1;
        long nextNum = 1;
        for (int i = 1; i < num; i++) {
            sum += nextNum;
            lastNum = currNum;
            currNum = nextNum;
            nextNum = lastNum + currNum;
        }

        return sum; // 1 1 2 3 5 8 13 21 34 55
    }

    public static long fibonacci(long max) {
        // Your code goes here
        int sum = 0;
        int lastNum = 0;
        int currNum = 1;
        int nextNum = 1;
        while (nextNum < max) {
            if (nextNum % 2 == 0)
                sum += nextNum;
            lastNum = currNum;
            currNum = nextNum;
            nextNum = lastNum + currNum;
        }

        return sum;
    }
}