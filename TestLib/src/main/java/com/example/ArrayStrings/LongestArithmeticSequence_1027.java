package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence_1027 {

//    Input: [3,6,9,12]
//    Output: 4
//    Explanation:
//    The whole array is an arithmetic sequence with steps of length = 3.
//    https://leetcode.com/problems/longest-arithmetic-sequence/
//    https://leetcode.com/problems/longest-arithmetic-subsequence/discuss/274701/Java-DP-O(n2)-solution-with-explanation
//    time complexity 0(n^2)

    public static void main(String args[]) {
        int[] input = {3,6,9,12};
        int res = longestArithSeqLength(input);
        System.out.println(res);
    }

    //create a hashMap for every index from 0 to len-1
    //Obtain the maximum chain length already seen so far at index i
    //for the given differene d;
    public static int longestArithSeqLength(int[] A) {
        if (A.length <= 1) return A.length;
//        {3,6,9,12};
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