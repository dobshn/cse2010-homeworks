package cse2010.hw4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Fibonacci {

    // Iterative
    public static int fibIter(int n) {
        if (n <= 1)
            return n;

        int acc = 1;
        int prev = 0;

        while (n-- > 1) {
            int temp = acc;
            acc += prev;
            prev = temp;
        }
        return acc;
    }

    // Tail Recursion
    public static int fib(int n) {
        return fibTailRec(n, 1, 0);
    }

    private static int fibTailRec(int n, int current, int prev) {
        if (n == 0) return 0;
        if (n <= 1) return current;
        return fibTailRec(n - 1, current + prev, current);
    }

    public static void main(String... args) {
        // Iterative
        System.out.println(
                Arrays.toString(IntStream.rangeClosed(0, 20).map(Fibonacci::fibIter).toArray())
        );

        // Tail Recursion
        System.out.println(
                Arrays.toString(IntStream.rangeClosed(0, 20).map(Fibonacci::fib).toArray())
        );
    }
}
