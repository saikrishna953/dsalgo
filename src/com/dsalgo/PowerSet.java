package com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//find all subsequences of a string
public class PowerSet {
    public static void main(String[] args) {
        List<String> result = solution("abc");
        result.forEach(System.out::println);
    }

    private static List<String> solution(String s) {

        int n = s.length();
        List<String> result = new ArrayList<>();
        long pow_set_size = (long) Math.pow(2,n);
        for (int i = 0; i < pow_set_size; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                int x = 1 << j;
                if ((i & x) > 0) {
                    str += s.charAt(j);
                }
            }
            if (!str.isEmpty()) {
                result.add(str);
            }
        }
        Collections.sort(result);
        return result;
    }
}
