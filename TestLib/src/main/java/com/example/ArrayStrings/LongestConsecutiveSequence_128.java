package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

//    Input: [100, 4, 200, 1, 3, 2]
//    Output: 4
//    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//    https://leetcode.com/problems/longest-consecutive-sequence/
//    Time complexity 0(n)

    public static void main(String args[]) {
        int[] input = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(input);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentSequenceLength = 1;
            if (!set.contains(currentNum-1)) {
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currentSequenceLength++;
                }
                maxLength = Math.max(maxLength, currentSequenceLength);
            }
        }
        return maxLength;
    }
}
