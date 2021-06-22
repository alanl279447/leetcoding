package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_525 {

//    Input: [0,1,0]
//    Output: 2
//    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//    https://leetcode.com/problems/contiguous-array/
    public static void main(String[] args) {
        int[] input = {0,1,0};
        System.out.println(findMaxLength(input));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}