package com.example.DynamicProgramming;

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

    public static void main(String[] args) {
        int[] input = {1,2,2,3,1,4,2};
//        int[] prices = {1};
        System.out.println(findShortestSubArray(input));
    }

    public static int findShortestSubArray(int[] A) {
        Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = 0; i < A.length; ++i) {
            first.putIfAbsent(A[i], i);
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            if (count.get(A[i]) > degree) {
                degree = count.get(A[i]);
                res = i - first.get(A[i]) + 1;
            } else if (count.get(A[i]) == degree)
                res = Math.min(res, i - first.get(A[i]) + 1);
        }
        return res;

    }


}
