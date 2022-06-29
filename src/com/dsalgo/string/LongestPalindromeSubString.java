package com.dsalgo.string;

//to do in dp
public class LongestPalindromeSubString {

    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        String result = longestPalindromeSubstring(s);
        System.out.println(result);
    }

    private static String longestPalindromeSubstring(String s) {
        int maxLen=1;
        int n = s.length();
        if(n<2){
            return s;
        }
        int low, high;
        int start=0;
        for (int i = 0; i < n; i++) {
            low = i-1;
            high = i+1;
            while(high < n && s.charAt(high) == s.charAt(i)){
                high++;
            }
            while(low >=0 && s.charAt(low) == s.charAt(i)){
                low--;
            }
            while(low>=0 && high <n && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
            int len = high -low-1;
            if(maxLen < len){
                maxLen = len;
                start = low+1;
            }
        }
        return s.substring(start,start+maxLen);
    }
}
