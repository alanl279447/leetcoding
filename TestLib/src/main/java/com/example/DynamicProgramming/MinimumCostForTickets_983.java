package com.example.DynamicProgramming;

import java.util.Arrays;

public class MinimumCostForTickets_983 {

//    Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//    Output: 11
//    Explanation:
//    For example, here is one way to buy passes that lets you travel your travel plan:
//    On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
//    On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
//    On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
//    In total you spent $11 and covered all the days of your travel.
//    https://leetcode.com/problems/minimum-cost-for-tickets/

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};
        System.out.print(mincostTickets(days, cost));
    }

    //int n = days[days.length-1];
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1];
        //the dag is dp[i] = min{ dp[i-1] + cost[0], dp[i-7] + cost[1], dp[i-30] + cost[2] }
        int[] dp = new int[n+1];
        boolean[] travelDay = new boolean[n+1];

        for(int i = 0; i < days.length; i++){
            int day = days[i];
            travelDay[day] = true;
        }

        for(int i = 1; i < dp.length; i++){
            if(travelDay[i] == false) {
                dp[i] = dp[i-1];
                continue;
            }
            int one = dp[i-1] + costs[0];
            int sev = dp[Math.max(0, i-7)] + costs[1];
            int thir = dp[Math.max(0, i-30)] + costs[2];

            dp[i] = Math.min(one, Math.min(sev, thir));
        }
        return dp[n];
    }
}