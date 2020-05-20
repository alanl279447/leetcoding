package com.example.DynamicProgramming;

import java.util.Arrays;

public class CoinChange_322 {

//    Input: coins = [1, 2, 5], amount = 11
//    Output: 3
//    Explanation: 11 = 5 + 5 + 1
//
//    Input: coins = [2], amount = 3
//    Output: -1
//    https://leetcode.com/problems/coin-change/

    public static void main(String[] args) {
        int[] prices = {1,2,5};
        System.out.print(coinChangeBottomUp(prices, 11));
    }

    //bottom up approach
    public static int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i=1; i<= amount; i++) {
            for (int j=0; j <coins.length;j++) {
                if (coins[j] <= i)
                 dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    //Dynamic programming -- Bottom up approach
//    public static int coinChangeBottomUp(int[] coins, int amount) {
//        int max = amount + 1;
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, max);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

    //Dynamic programming -- Top down  approach
    public static int coinChange(int[] coins, int amount) {
      int result = -1;
      coinChangeInner(coins, amount, new int[amount]);
      return result;
    }

    public static int coinChangeInner(int[] coins, int amount, int[] count) {
        if(amount < 0) {
            return -1;
        }
        if (amount ==0) {
            return 0;
        }
        if (count[amount-1] != 0) {
            return count[amount-1];
        }

        int minValue = Integer.MAX_VALUE;
        for (int coin: coins) {
           int res = coinChangeInner(coins, amount-coin, count);
           if (res >0 && res>minValue) {
               minValue = res+1;
           }
        }
        count[amount-1] = minValue == Integer.MAX_VALUE?-1:minValue;
        return count[amount-1];
    }


    //Dynamic programming -- Top down approach
    public static int coinChangeTop(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChangeTop(coins, amount, new int[amount]);
    }

    private static int coinChangeTop(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeTop(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
