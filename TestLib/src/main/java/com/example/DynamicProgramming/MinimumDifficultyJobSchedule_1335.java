package com.example.DynamicProgramming;

public class MinimumDifficultyJobSchedule_1335 {

//    Input: jobDifficulty = [6,5,4,3,2,1], d = 2
//    Output: 7
//    Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
//    Second day you can finish the last job, total difficulty = 1.
//    The difficulty of the schedule = 6 + 1 = 7
//    https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

    public static void main(String[] args) {
        //int[] jobDifficulty = {6,5,4,3,2,1};
        int[] jobDifficulty = {1,5,3,2,4};
        System.out.print(minDifficulty(jobDifficulty, 2));
    }

    public static int minDifficulty(int[] jobDifficulty, int Days) {
        final int jobLength = jobDifficulty.length;
        if(jobLength < Days) return -1;
        int[][] dp = new int[Days][jobLength];

        dp[0][0] = jobDifficulty[0];
        for(int j = 1; j < jobLength; ++j){   //base condition for 1 days
            dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
        }
        for(int d = 1; d < Days; ++d){   //looping through days
            for(int len = d; len < jobLength; ++len){
                int localMax = jobDifficulty[len];
                dp[d][len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule >= d; --schedule){
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
                }
            }
        }
        return dp[Days - 1][jobLength - 1];
    }
}