package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
//    Input: [23, 2, 4, 6, 7],  k=6
//    Output: True
//    Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//    https://leetcode.com/problems/subarray-sum-equals-k/

    public static void main(String args[]) {
        int[] input = {23,2,4,6,7};
        int res = subarraySum(input, 6);
        System.out.println(res);
    }

    //map (sum, position), (0,1), (23,1), (25,1), ()
    public static int subarraySum(int[] nums, int k) {
        int result = 0, sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i=0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }




}
