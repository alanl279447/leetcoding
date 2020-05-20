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

    public static int maxProfitSlow(int[] prices, int K) {
        int[][]profit = new int[K][prices.length];

        for (int i=0;i<profit.length;i++) {
            for (int j =0; j < profit[0].length; j++) {
                int maxValue = 0;
                for (int m=0; m < j; m++) {
                    maxValue = Math.max(maxValue, prices[j]-prices[m]+profit[i-1][m]);
            }
                profit[i][j]= Math.max(profit[i][j-1], maxValue);
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

        for (int i = 1; i < profit.length; i++) {
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





//    public static int maxProfit(int[] prices) {
//      int minPrice = Integer.MAX_VALUE;
//      int maxPrice = 0;
//
//      for (int price: prices) {
//        if (price < minPrice) {
//            minPrice = price;
//        }
//        if(price - minPrice > maxPrice) {
//            maxPrice = price - minPrice;
//        }
//      }
//      return maxPrice;
//    }


}
