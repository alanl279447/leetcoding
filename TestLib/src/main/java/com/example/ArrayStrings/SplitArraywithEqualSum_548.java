package com.example.ArrayStrings;

//Input: [1,2,1,2,1,2,1]
//        Output: True
//        Explanation:
//        i = 1, j = 3, k = 5.
//        sum(0, i - 1) = sum(0, 0) = 1
//        sum(i + 1, j - 1) = sum(2, 2) = 1
//        sum(j + 1, k - 1) = sum(4, 4) = 1
//        sum(k + 1, n - 1) = sum(6, 6) = 1
//        https://leetcode.com/problems/split-array-with-equal-sum/

// for j in range
//   for i in
//      if sum (0, i-1) == sum(i+1, j-1)
//        save the same in set
//   for K in
//    if sum(j+1, k-1) == sum(k+1, n-1) == one of the sum in set
//        return true

//0 < i, i + 1 < j, j + 1 < k < n - 1
//Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.

import java.util.HashSet;
import java.util.Set;

public class SplitArraywithEqualSum_548 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,1};
        System.out.println(splitArray(nums));
    }

    public static boolean splitArray(int[] nums) {
       int len = nums.length;
       int[] sum = new int[nums.length];
       sum[0] = nums[0];
       for (int i=1; i < len; i++) {
           sum[i] += sum[i-1]+nums[i];
       }
       for (int j = 3; j < len-3; j++) {
           Set<Integer> set = new HashSet<Integer>();
           for (int i = 1; i < j-1; i++) {
               if (sum[i-1] == sum[j-1] - sum[i]) {
                   set.add(sum[i-1]);
               }
           }
           for (int k = j+2; k < len-1; k++) {
               if (sum[k-1]-sum[j] == sum[len-1]-sum[k] && set.contains(sum[k-1]-sum[j])) {
                   return true;
               }
           }
       }
       return false;
    }
}