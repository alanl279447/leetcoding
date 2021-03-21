package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum_209 {

//    Input: s = 7, nums = [2,3,1,2,4,3]
//    Output: 2
//    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//    https://leetcode.com/problems/minimum-size-subarray-sum/

    //Related topic
    //https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

    public static void main(String args[]) {
        int[] input = {2,3,1,2,4,3};
        int res = minSubArrayLen(7, input);
        System.out.println(res);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int lo = 0, hi = 0, sum = 0, ml = nums.length + 1;
        while (hi < nums.length){
            sum += nums[hi];
            while (sum >= s) {
                ml = Math.max(ml, hi - lo + 1);
                sum -= nums[lo];
                lo ++;
            }
            hi ++;
        }
        return ml > nums.length ? 0 : ml;
    }
}
