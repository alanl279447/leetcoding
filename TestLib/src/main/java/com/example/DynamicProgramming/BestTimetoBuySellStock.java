package com.example.DynamicProgramming;

public class BestTimetoBuySellStock {

//    Input: [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//    Input: [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.print(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i< prices.length;i++) {
            if (prices[i] < min) {
                min = prices[i];   //always the lowest
            }

            if (profit < (prices[i] - min)) {
                profit = prices[i]-min;
            }
        }
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
