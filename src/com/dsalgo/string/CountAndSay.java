package com.dsalgo.string;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public static void main(String[] args) {
        String ans = solution(4);
        System.out.println(ans);
    }

    private static String solution(int n) {
        if (n == 1) {
            return "1";
        }
        String s = solution(n - 1);
        char c = s.charAt(0);
        int count = 1, i = 1;
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            if (!(s.charAt(i) == c)) {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
            i++;
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
