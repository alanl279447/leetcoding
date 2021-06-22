package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/
//        Input: nums = [1,2,3]
//        Output: [1,2]
//        Explanation: [1,3] is also accepted.

public class LargestDivisibleSubset_368 {

    public static void main(String[] args) {
        int[] input =  {1,2,4,8};
        List<Integer> res = largestDivisibleSubset(input);
        for (int re: res) {
            System.out.println(re);
        }
    }

    //time complexity 0(n^2)
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) return null;
        Arrays.sort(nums);

        int len = nums.length;
        int[] dp = new int[len];
        int[] prev = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = -1, index = -1;
        for (int i = 0; i < len; i++) {
           for (int j = i-1; j >=0; j--) {
             if (nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]) {
                 dp[i] = dp[j]+1;
                 prev[i] = j;
             }
             if (dp[i] > max) {
                 max = dp[i];
                 index = i;
             }
           }
        }

        while(index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }
}