package com.example.DynamicProgramming;

public class Longest_Palindromic_Subsequence_516 {

//    "bbbab"
//    4
//    One possible longest palindromic subsequence is "bbbb".
//    https://leetcode.com/problems/longest-palindromic-subsequence/

    public static void main(String[] args) {
        System.out.print(LongestPalindromeSubseq("agbdba"));
    }

//    https://www.youtube.com/watch?v=_nCsPn7_OgI
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
                int max = Math.max(dp[i][j-1], dp[i+1][j]); ////agbdba  for 2-4 (bdb)  max b/w bd or db
                if (s.charAt(i) == s.charAt(j))
                {
                    // now check 2 plus without left and without right
                    max = Math.max(max, 2 + dp[i+1][j-1]);   //agbdba  for 0-5(agbda)  max b/w(1-4) + 2 (corner a's)
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}