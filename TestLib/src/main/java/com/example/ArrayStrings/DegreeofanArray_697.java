package com.example.ArrayStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray_697 {
//    Input: [1, 2, 2, 3, 1]
//    Output: 2
//    Explanation:
//    The input array has a degree of 2 because both elements 1 and 2 appear twice.
//    Of the subarrays that have the same degree:
//            [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//    The shortest length is 2. So return 2.
//    https://leetcode.com/problems/degree-of-an-array/

    public static void main(String args[]) {
        int[] input = {1,2,2,3,1};
        int result = findShortestSubArray(input);
            System.out.println(result);
    }

    // 0(n) time complexity
    public static int findShortestSubArrayFast(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        int res = 0, degree = 0;
        for (int i=0;i<nums.length;i++) {
            firstMap.putIfAbsent(nums[i], i);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) +1);
            if (countMap.get(nums[i]) > degree) {
                res = i - firstMap.get(nums[i])+1;
                degree = countMap.get(nums[i]);
            } else if (countMap.get(nums[i])==degree) {
                res = Math.min(res, i-firstMap.get(nums[i])+1);
            }
        }
        return res;
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int num:nums) {
            if (degree==count.get(num)) {
                ans = right.get(num)-left.get(num)+1;
            }
        }
        return ans;
    }
}
