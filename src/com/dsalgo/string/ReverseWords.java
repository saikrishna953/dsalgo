package com.dsalgo.string;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "  h world  ";
        String result = solution(s);
        System.out.println(result);
    }

    private static String solution(String s) {

        int j = s.length() - 1;
        StringBuilder result = new StringBuilder();
        while (j >= 0) {
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            int endIndex = j + 1;
            while (j >= 0 && Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            int startIndex = j + 1;
            result.append(s.substring(startIndex, endIndex));
            result.append(" ");
        }
        return result.toString();
    }
}
