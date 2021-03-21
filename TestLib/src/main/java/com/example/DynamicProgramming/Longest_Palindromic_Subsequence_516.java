package com.example.DynamicProgramming;

public class Longest_Palindromic_Subsequence_516 {

//    "bbbab"
//    4
//    One possible longest palindromic subsequence is "bbbb".
//    https://leetcode.com/problems/longest-palindromic-subsequence/

    public static void main(String[] args) {
        System.out.print(LongestPalindromeSubseq("agbdba"));
    }

    public static int LongestPalindromeSubseq(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];

        // len 1
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        // len 2
        for (int i = 0, j = 1; j < n; i++, j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
        }

        // len 3 and up
        for (int len = 3; len <= n; len++)
        {
            for (int i = 0, j = len - 1; j < n; i++, j++)
            {
                // better of without left or without right
                int max = Math.max(dp[i][j-1], dp[i+1][j]);
                if (s.charAt(i) == s.charAt(j))
                {
                    // now check 2 plus without left and without right
                    max = Math.max(max, 2 + dp[i+1][j-1]);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n-1];
    }

}