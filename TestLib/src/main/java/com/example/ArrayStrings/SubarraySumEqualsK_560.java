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

//    I see ...After spending some time on the analysis,
//    I found the reason behind having initialize preSum.put(0,1)....it is for those (sum - k) == 0
//    calculations which are valid subarrays but need to get counted. e.g. if k = 7 and sum = 7
//    (at second element for array is : 3, 4, 3, 8) at some iteration.....then sum - k = 0....this 0
//    will get counted in statement result += preSum.get(sum - k);

    //(0, 1), (1, 23), (2,25), (3, 29), (4,31), (5, 37)
    // 23-6, 25-6, 29-6 =23, 36-6

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
