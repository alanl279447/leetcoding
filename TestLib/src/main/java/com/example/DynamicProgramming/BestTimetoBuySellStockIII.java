package com.example.DynamicProgramming;

public class BestTimetoBuySellStockIII {

//    Input: [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//    Input: [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 10};
        System.out.print(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 0) {
            return 0;
        }
        int leftMin = prices[0];
        int rightMax = prices[length - 1];
        int[] leftProfits = new int[length];
        // pad the right DP array with an additional zero for convenience.
        int[] rightProfits = new int[length + 1];
        // construct the bidirectional DP array
        for (int l = 1; l < length; ++l) {
            leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);
            int r = length - 1 - l;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }
        int maxProfit = 0;
        for (int i = 0; i < length; ++i) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }
        return maxProfit;
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
