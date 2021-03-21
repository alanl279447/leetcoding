package com.example.DynamicProgramming;

public class BestTimetoBuySellStockIV {

//    Input: [3,2,6,5,0,3], k = 2
//    Output: 7
//    Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//    Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.print(maxProfit(prices, 2));
    }

//    In order to reduce it to O(nk), we must find t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1])
//    this expression in constant time. If you see carefully,
//    t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) is same as
//    prices[j] + t:0->j-1 max(dp[i-1][t-1]-prices[t])
//    Second part of the above expression maxTemp = t:0->j-1 max(dp[i-1][t-1]-prices[t])
//    can be included in the dp loop by keeping track of the maximum value till j-1.
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java


    public static int maxProfitTest(int[] prices, int K) {
        if (K==0 || prices.length==0) return 0;

        if (K > prices.length/2) {
            return quickSolve(prices);
        }
        int[][] profit = new int[K+1][prices.length];  //i - transactions, j - days
        for (int i=0; i < profit.length; i++) {
            int tempMax =  - prices[0];
            for (int j = 1; j < profit[0].length; j++) {
                profit[i][j] = Math.max(profit[i][j-1], tempMax+prices[j]);
                tempMax = Math.max(tempMax, profit[i-1][j-1] - prices[j]);
                //t:0->j-1 max(prices[j]-prices[t]+dp[i-1][t-1]) is same as
                //prices[j] + t:0->j-1 max(dp[i-1][t-1]-prices[t])
            }
        }
        return profit[K][prices.length-1];
    }

    public static int maxProfit(int[] prices, int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        if (K >= prices.length / 2) return quickSolve(prices);
        int profit[][] = new int[K+1][prices.length];
        for (int i = 1; i < profit.length; i++) {   // i - transaction, j - no of days
            int maxDiff = -prices[0];
            for (int j = 1; j < profit[0].length; j++) {
                profit[i][j] = Math.max(profit[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profit[i-1][j] - prices[j]);
            }
        }
        return profit[K][prices.length-1];
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    //    public static int maxProfitSlow(int[] prices, int K) {
//        int[][]profit = new int[K][prices.length];
//
//        for (int i=0;i<profit.length;i++) {
//            for (int j =0; j < profit[0].length; j++) {
//                int maxValue = 0;
//                for (int m=0; m < j; m++) {
//                    maxValue = Math.max(maxValue, prices[j]-prices[m]+profit[i-1][m]);
//            }
//                profit[i][j]= Math.max(profit[i][j-1], maxValue);
//            }
//        }
//        return profit[K][prices.length-1];
//    }
}