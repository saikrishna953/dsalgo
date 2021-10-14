package com.dsalgo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongConsecutiveSeq {

    public static void main(String[] args) {
        int[] nums = {102, 4, 100, 1, 101, 3, 2};
        int ans = longestConsecutiveSequence(nums);
        System.out.println("Longest consecutive sequence is:" + ans);
    }

    private static int longestConsecutiveSequence(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
