package com.example.DynamicProgramming;

public class LongestCommonSubsequence_1143 {
//    Input: text1 = "abcde", text2 = "ace"
//    Output: 3
//    Explanation: The longest common subsequence is "ace" and its length is 3.
//    https://leetcode.com/problems/longest-common-subsequence/

    public static void main(String[] args) {
        int res = longestCommonSubsequence("abcdge", "acge");
        System.out.println(res);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int max = 0;

        for (int i = 1; i <dp.length; i++) {
            for (int j =1; j < dp[0].length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
