package com.example.DynamicProgramming;

import java.util.Arrays;

public class CoinChange2_518 {

//    Input: amount = 5, coins = [1, 2, 5]
//    Output: 4
//    Explanation: there are four ways to make up the amount:
//            5=5
//            5=2+2+1
//            5=2+1+1+1
//            5=1+1+1+1+1
//    https://leetcode.com/problems/coin-change-2/

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.print(change(5, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
}