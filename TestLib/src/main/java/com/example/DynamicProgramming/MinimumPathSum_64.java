package com.example.DynamicProgramming;

public class MinimumPathSum_64 {

//    Input:
//            [
//            [1,3,1],
//            [1,5,1],
//            [4,2,1]
//            ]
//    Output: 7
//    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//    https://leetcode.com/problems/minimum-path-sum/

    public static void main(String[] args) {

        int[][] paths = {{1,3,1}, {1,5,1}, {4,2,1}};
        int res = minPathSum(paths);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid) {

        if (grid == null || grid.length < 1) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
              dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
