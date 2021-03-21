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
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 10};
        System.out.print(maxProfit(prices));
    }
//    Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
//    Then the tricky part comes, how to handle the twoBuy? Suppose in real life,
//    you have bought and sold a stock and made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars,
//    how would you think this? You must think, um, I have made $100 profit,
//    so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
//    There we go, you got the idea how we calculate twoBuy!!
//    We just minimize the cost again!! The twoBuyTwoSell is just making as much profit as possible.
//    Hope this explanation helps other people to understand this!
    public static int maxProfit(int[] prices) {
        int oneBuyOneSell = 0;
        int twoBuyTwoSell = 0;
        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            int p = prices[i];
            oneBuy = Math.min(oneBuy, p);
            oneBuyOneSell = Math.max(oneBuyOneSell, p - oneBuy);
            twoBuy = Math.min(twoBuy, p - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, p - twoBuy);
        }
        return twoBuyTwoSell;
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
