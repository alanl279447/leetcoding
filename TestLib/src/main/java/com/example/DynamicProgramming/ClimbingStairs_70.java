package com.example.DynamicProgramming;

public class ClimbingStairs_70 {

//    Input: 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//    https://leetcode.com/problems/climbing-stairs/

    public static void main(String[] args) {
        int res = climbStairs(3);
        System.out.println(res);
    }

//    public static int climbStairsSpaceOptimized(int n) {
//
//        if (n ==1) {
//            return n;
//        }
//        int first = 1;
//        int second = 1;
//        int current = 0;
//
//        for (int i = 2; i <=n; i++) {
//            current = second+first;
//            first = second;
//            second = current;
//        }
//        return current;
//    }

        public static int climbStairs(int n) {

        if (n ==1) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
