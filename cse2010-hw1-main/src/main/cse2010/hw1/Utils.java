package cse2010.hw1;

public class Utils {

    public static int findIndex(int[] xs, int target) {

        for (int i = 0; i < xs.length ; i++) {

            if (xs[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static double sum(double[] xs) {

        double sum = 0;

        for (double x : xs) {
            sum += x;
        }

        return sum;
    }

    public static String[] reverse(String[] xs) {

        String[] reversed_xs = new String[xs.length];

        for (int i = 0; i < xs.length; i++) {
            reversed_xs[i] = xs[(xs.length - 1) - i];
        }

        return reversed_xs;
    }

    public static void swap(int[] xs, int i, int j) {

        int temp = xs[i];

        xs[i] = xs[j];
        xs[j] = temp;
    }

    public static void reverse_in_place(String[] xs) {

        for (int i = 0; i < (xs.length / 2); i++) {

            String temp = xs[i];

            xs[i] = xs[xs.length - 1 - i];
            xs[xs.length - 1 - i] = temp;
        }

    }

    public static double[] average(int[] xs) {

        double[] agv_xs = new double[xs.length];

        for (int i = 0; i < xs.length; i++) {

            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += xs[j];
            }

            agv_xs[i] = sum / (i + 1.0);
        }

        return agv_xs;
    }
}
