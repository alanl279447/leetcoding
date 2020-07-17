package com.example.DynamicProgramming;

public class LongestTurbulentSubarray_978 {

//    Input: [9,4,2,10,7,8,8,1,9]
//    Output: 5
//    Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
//    https://leetcode.com/problems/longest-turbulent-subarray/

    public static void main(String[] args) {
        int[] prices = {9,4,2,10,7,8,8,1,9};
        System.out.print(maxTurbulenceSize(prices));
    }

    public static int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }
}
