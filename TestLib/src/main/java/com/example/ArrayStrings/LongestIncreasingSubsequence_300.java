package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.Stack;

//        Input: [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//        https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18,1};
       // int[] input = {4,5,6,3};
        int result = lengthOfLIS(input);
        System.out.print(result);
    }

//    (1) if x is larger than all tails, append it, increase the size by 1
//    (2) if tails[i-1] < x <= tails[i], update tails[i]

    //time complexity 0(nlonn)
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    //{10,9,2,5,3,7,101,18};
    public static int lengthOfLIS_arrays(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
