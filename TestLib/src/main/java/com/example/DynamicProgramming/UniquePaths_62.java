package com.example.DynamicProgramming;

public class UniquePaths_62 {

//    Input: m = 3, n = 2
//    Output: 3
//    Explanation:
//    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//        1. Right -> Right -> Down
//    2. Right -> Down -> Right
//    3. Down -> Right -> Right
//
//    https://leetcode.com/problems/unique-paths/

    public static void main(String[] args) {
        int res = uniquePaths(3, 2);
        System.out.println(res);
    }

    public static int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];

       for(int i =0; i < dp.length; i++) {
           dp[i][0] = 1;
       }

        for(int i =0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i=1; i<dp.length;i++) {
            for (int j=1; j<dp[0].length;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

}
