package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk_325 {

//    Input: nums = [1, -1, 5, -2, 3], k = 3
//    Output: 4
//    Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest

    //    Input: nums = [-2, -1, 2, 1], k = 1
    //    Output: 2
    //    Explanation: The subarray [-1, 2] sums to 1 and is the longest.
//    https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

    public static void main(String args[]) {
        int[] input = {1, -1, 5, -2, 3};
        int res = maxSubArrayLen(input, 3);
        System.out.println(res);
    }

//    input: 1, -1, 5, -2, 3  k = 3   0/p = 4

    public static int maxSubArrayLen(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // right - left = k -> left = right - k
        int ans = 0, right;
        for (int i = 0; i < prefixSum.length; i++) {
            right = prefixSum[i];
            int left = right - k;
            if (map.containsKey(left)) {
                ans = Math.max(ans, i - map.get(left));
            }
            map.putIfAbsent(right, i); // make current right as left for later retrieve
        }
        return ans;
    }

    //    public static int maxSubArrayLenPrac(int[] arr, int k) {
//      int[] preSum = new int[arr.length+1];
//      for (int i=1; i <= arr.length; i++) {
//          preSum[i] += preSum[i-1]+arr[i-1 ];
//      }
//      Map<Integer, Integer> map = new HashMap();
//      int ans = 0;
//      for(int i=0; i < arr.length;i++) {
//          int right = preSum[i];
//          int left = right-k;
//          if (map.containsKey(left)) {
//              ans = Math.max(ans, i-map.get(left));
//          }
//
//      }
//
//    }
}
