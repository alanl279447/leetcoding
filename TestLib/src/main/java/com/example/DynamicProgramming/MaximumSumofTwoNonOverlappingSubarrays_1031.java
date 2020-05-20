package com.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofTwoNonOverlappingSubarrays_1031 {

//    Input: A = [6,5,1,9,4], L = 1, M = 2
//    Output: 20
//    Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
//    https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

    public static void main(String[] args) {
        int[] input = {6,7,1,9,4};
//        int[] prices = {1};
        System.out.println(maxSumTwoNoOverlap(input, 1,2));
    }

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(maxSum(A, L, M), maxSum(A, M, L));
    }
    private static int maxSum(int[] A, int L, int M) {
        int sumL = 0, sumM = 0;
        for (int i = 0; i < L + M; ++i) { // compute the initial values of L & M length subarrays.
            if (i < L) {
                sumL += A[i];
            } else {
                sumM += A[i];
            }
        }
        int ans = sumM + sumL; // sum of sumL and sumM.
        for (int i = L + M, maxL = sumL; i < A.length; ++i) {
            sumM += A[i] - A[i - M]; // update sumM.
            sumL += A[i - M] - A[i - L - M]; // update sumL.
            maxL = Math.max(maxL, sumL); // update max value of L-length subarray.
            ans = Math.max(ans, maxL + sumM); // update max value of sum of L & M-length subarrays.
        }
        return ans;
    }
}
