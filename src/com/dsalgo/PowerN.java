package com.dsalgo;

public class PowerN {

    public static void main(String[] args) {
        int power = 10;
        int number = 2;
        double answer = powerOfNumber(power, number);
        System.out.println(number + " to the power of " + power + " is " + answer);
    }

    //brute force approach would be to iterate from 1 to n and multiply with previous result.

    private static double powerOfNumber(int p, int n) {

        double answer = 1.0;
        long nn = p;
        if (nn < 0) {
            nn = (-1) * nn;
        }
        while (nn > 0) {

            if (nn % 2 == 1) {
                answer = answer * n;
                nn = nn - 1;
            } else {
                n *= n;
                nn = nn / 2;
            }
        }
        if (p < 0) {
            answer = 1 / answer;
        }
        return answer;
    }
}
