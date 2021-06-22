package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaximumSumof3NonOverlappingSubarrays_689 {

//    Input: [1,2,1,2,6,7,5,1], 2
//    Output: [0, 3, 5]
//    Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
//    We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
//    https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
    //update rule max_of_i = max(max_of_i, max_of{i-1)+current_subArray_i

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
                dp[i - k + 1] = sum;  //3,3,3,8,13,12,6
            }
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }

            left[i] = maxIndex;    //0,0,0,3,4,4,4
        }

        maxIndex = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] >= dp[maxIndex]) {
                maxIndex = i;
            }

            right[i] = maxIndex;    //4,4,4,4,4,5,6
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

    public static List<Integer> maxSumOfThreeSubarraysTest(int[] nums, int k, int m) {
        int len = nums.length;
        int n = len - k + 1;
        int[] window_sums = new int[n];    //3,3,3,8,13,12,6
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            // 0, 1, 2
            if (i >= k) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                window_sums[i - k + 1] = sum;
            }
        }
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i=0; i < m; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for (int j=0; j < 2; j++) {
                map.get(i).add(j, new ArrayList<>());
            }
        }

        for (int s = 0; s < len-k*m+1; s++) { //
          for (int i = 1; i <= m; i ++) {     //p is the subsequent window
              int l = s + (i-1)*k;
              int window_sum = window_sums[l];
              if (window_sum+map.get(i-1).get(0).get(0) > map.get(i).get(0).get(0)) {
                  map.get(i).get(0).add(0,window_sum+map.get(i-1).get(0).get(0));

                  List<Integer> temp = map.get(i-1).get(1);   //add the current index to the prev list
                  temp.add(l);
                  map.get(i).add(1,temp);
              }
          }
        }
         return map.get(m).get(1);
    }
}