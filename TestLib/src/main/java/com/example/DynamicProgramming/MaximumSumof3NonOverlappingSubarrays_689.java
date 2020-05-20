package com.example.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumof3NonOverlappingSubarrays_689 {

//    Input: [1,2,1,2,6,7,5,1], 2
//    Output: [0, 3, 5]
//    Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
//    We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
//    https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,6,7,5,1};
        int[] result = maxSumOfThreeSubarrays(nums, 2);
        for (int res: result)
         System.out.println(res);
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int n = len - k + 1;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            // 0, 1, 2
            if (i >= k) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                dp[i - k + 1] = sum;
            }
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }

            left[i] = maxIndex;
        }

        maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] >= dp[maxIndex]) {
                maxIndex = i;
            }

            right[i] = maxIndex;
        }

        int[] res = new int[3];
        Arrays.fill(res, -1);

        for (int i = k; i < n - k; i++) {
            if (res[0] == -1 || dp[res[0]] + dp[res[1]] + dp[res[2]] <
                    dp[left[i - k]] + dp[i] + dp[right[i + k]]) {
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }

        return res;
    }


}
