package com.dsalgo.string;

//https://leetcode.com/problems/roman-to-integer/
public class RomanToInt {

    public static void main(String[] args) {

        int ans = romanToInt("MCMXCIV");
        System.out.println(ans);
    }

    public static int romanToInt(String s) {

        int num = 0;
        int temp = 1;
        int i = 0;

        while (i < s.length()) {
            if (temp < s.length() && getnum(s.charAt(temp)) > getnum(s.charAt(i))) {
                num += getnum(s.charAt(temp)) - getnum(s.charAt(i));
                i += 2;
                temp += 2;
            } else {
                num += getnum(s.charAt(i));
                temp++;
                i++;
            }

        }
        return num;
    }

    public static int getnum(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;

        return 0;
    }
}
