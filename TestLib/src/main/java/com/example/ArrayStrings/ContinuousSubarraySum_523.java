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

//    https://leetcode.com/problems/continuous-subarray-sum/discuss/99503/Need-to-pay-attention-to-a-lot-of-corner-cases...
    //input  23,2,4,6,7
    //sum    23,7,5,11, 12
    //sum%k  5,1, 5, 5, 0
    //map    -1
    // (x + n*k) mod k = x ,which x can be 0,1,...,k-1.
    public static boolean checkSubarraySum(int[] nums, int k) {

        // Since the size of subarray is at least 2.
        if (nums.length <= 1) return false;
        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }

        // At this point, k can't be "0" any longer.
        if (k == 0) return false;
        // Let's only check positive k. Because if there is a n makes n * k = sum, it is always true -n * -k = sum.
        if (k < 0) k = -k;

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
