package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {

//    Input: [23, 2, 4, 6, 7],  k=6
//    Output: True
//    Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//    https://leetcode.com/problems/continuous-subarray-sum/

    public static void main(String args[]) {
        int[] input = {23,2,4,6,7};
        boolean res = checkSubarraySum(input, 6);
        System.out.println(res);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i =0; i < nums.length; i++) {
            sum +=nums[i];
            if (k!= 0)
                sum = sum %k;
            if (map.containsKey(sum)) {
                if(i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

}
