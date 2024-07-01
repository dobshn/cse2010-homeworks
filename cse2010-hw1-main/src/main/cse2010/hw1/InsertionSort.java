package cse2010.hw1;

public class InsertionSort {

    public static void isort(int[] xs) {

        for (int i = 1; i < xs.length; i++) {
            insert(xs, i);
        }
    }

    private static void insert(int[] xs, int k) {

        while ((k > 0) && (xs[k-1] < xs[k])) {
            Utils.swap(xs, k, k-1);
            k -= 1;
        }
    }
}
