package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestContinuousIncreasingSubsequence674 {
//    Input: [1,3,5,4,7]
//    Output: 3
//    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
//    Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
//    https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public static void main(String args[]) {
        int[] input = {1,3,5,4,7};
        int res = findLengthOfLCIS(input);
        System.out.println(res);
    }


    public static int findLengthOfLCIS(int[] nums) {
       int maxLength = 0, count=0;
       for (int i =0; i < nums.length; i++) {
           if (i==0||nums[i] > nums[i-1]) {
               maxLength=Math.max(maxLength, ++count);
           } else {
               count=1;
           }
       }
       return maxLength;
    }
}
