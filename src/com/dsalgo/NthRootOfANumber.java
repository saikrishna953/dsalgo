package com.dsalgo;

public class NthRootOfANumber {

    public static void main(String[] args) {
        int n = 17;
        int m = 89;
        String ans = getNthRoot(n, m);
        System.out.println("Nth root of a number is " + ans);

        System.out.println(Math.pow(m, (1.0 / (double) n)));
    }

    private static String getNthRoot(int n, int m) {

        double low = 1;
        double high = m;
        double mid = 0;
        double esp = 1e-6;
        while ((high - low) > esp) {
            mid = (high + low) / 2;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low + " " + high;
    }

    private static double multiply(double number, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * number;
        }
        return ans;
    }
}
