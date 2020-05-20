package com.example.ArrayStrings;

import java.util.Arrays;

public class PerfectSquares_279 {
//    Input: n = 12
//    Output: 3
//    Explanation: 12 = 4 + 4 + 4.
//    https://leetcode.com/problems/perfect-squares/
//    Time complexity 0(n sqrt(n))

    public static void main(String args[]) {
        int result = numSquares( 12);
        System.out.println(result);
    }

    //use dynamic programming bottom up approach
    //every step, check minimum between dp[i] or dp[i-j*j]+1
    // return the final value at dp[n]
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i - j * j >= 0)
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
