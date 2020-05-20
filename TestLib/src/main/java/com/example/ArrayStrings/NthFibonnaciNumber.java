package com.example.ArrayStrings;

public class NthFibonnaciNumber {
//    Given a number ‘n’, write a function that prints the last digit of n’th (‘n’ can also be a large number) Fibonacci number.
//    Input : n = 0
//    Output : 0
//
//    Input: n = 2
//    Output : 1
//
//    Input : n = 7
//    Output : 3

    public static void main(String[] args) {

//        for (int i=0;i<board.length;i++) {
//            System.out.println(board[i].toString());
//        }
        System.out.println(nthFibonnaciNumber(61));
    }

    private static int nthFibonnaciNumber(int n) {

        int first = 0;
      int second = 1;

        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = (first + second)%10;
            first = second;
            second = res;
        }

        return res;
    }

}
