package com.example.Stack;

import java.util.Stack;

public class OnlineStockSpan_901 {

//    Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
//    Output: [null,1,1,1,2,1,4,6]
//    Explanation:
//    First, S = StockSpanner() is initialized.  Then:
//            S.next(100) is called and returns 1,
//            S.next(80) is called and returns 1,
//            S.next(60) is called and returns 1,
//            S.next(70) is called and returns 2,
//            S.next(60) is called and returns 1,
//            S.next(75) is called and returns 4,
//            S.next(85) is called and returns 6.
//
//    Note that (for example) S.next(75) returned 4, because the last 4 prices
//            (including today's price of 75) were less than or equal to today's price.
//     https://leetcode.com/problems/online-stock-span/

    static class StockSpanner {

        Stack<int[]> stack = null;
        public StockSpanner() {
           stack = new Stack<>();
        }

        public int next(int price) {
           int span = 1;
           while(!stack.isEmpty() && price >= stack.peek()[0]) {
               span +=stack.peek()[1];
               stack.pop();
           }
           stack.push(new int[]{price, span});
           return span;
        }
    }

    public static void main(String[] args) {
        //int[] T = {5,10,-5};
        int[] T = {-2, -1, 1, 2};
        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(100);
        System.out.print(param_1);
        int param_2 = obj.next(80);
        System.out.print(param_2);
        int param_3 = obj.next(60);
        System.out.print(param_3);
        int param_4 = obj.next(70);
        System.out.print(param_4);
        int param_5 = obj.next(60);
        System.out.print(param_5);
        int param_6 = obj.next(75);
        System.out.print(param_6);
        int param_7 = obj.next(85);
        System.out.print(param_7);
    }

}
