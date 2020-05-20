package com.example.DynamicProgramming;

public class BestTimetoBuySellStock_Amazon {

//    Input: [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//    Input: [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.

    public static void main(String[] args) {
//        BuyAndSellV bs5 = new BuyAndSellV();
        //int[] a = { 10, 11, 13, 14, 16, 18, 17, 10, 4, 14 }; // ans = 40
        int[] b = { 1,2,3,4,5 }; //ans = 10
        //int[] c = { 10, 12, 15, 12, 31, 24, 23, 10, 4, 14 }; //ans = 89
        int[] d = { 5,4,3,2,1 }; //ans = 0
        //System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));
//        System.out.println(maxProfit(c));
        System.out.println(maxProfit(d));
    }

    //helper API start, end, prices, profit
    // maxId for the range for start to end..
    //

    public static int maxProfit(int[] prices) {
        return helper(0, prices.length, prices, 0);
    }

    public static int helper(int start, int end, int[] prices, int profit) {
        if(start == end) return profit;

        // Find the max element of sub array
        int maxIdx = start;
        for(int i=start+1; i<end; i++) {
            if(prices[i] > prices[maxIdx]) maxIdx = i;
        }

        // If the start idx is max idx we can not buy it now, so proceed to next day
        if(maxIdx == start) {
            return helper(start+1, end, prices, profit);
        }

        // Add all the profit from start day to prev day of max idx
        for(int i=start; i<maxIdx; i++) {
            profit += prices[maxIdx] - prices[i];
        }

        // Proceed to next day
        return helper(maxIdx+1, end, prices, profit);
    }

}
