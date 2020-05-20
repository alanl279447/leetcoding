package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence_1027 {

//    Input: [3,6,9,12]
//    Output: 4
//    Explanation:
//    The whole array is an arithmetic sequence with steps of length = 3.
//    https://leetcode.com/problems/longest-arithmetic-sequence/

    public static void main(String args[]) {
        int[] input = {3,6,9,12};
        int res = longestArithSeqLength(input);
        System.out.println(res);
    }

    public static int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }

}
