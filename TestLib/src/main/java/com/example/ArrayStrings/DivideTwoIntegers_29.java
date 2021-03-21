package com.example.ArrayStrings;

public class DivideTwoIntegers_29 {

//    Input: dividend = 10, divisor = 3
//    Output: 3
//    https://leetcode.com/problems/divide-two-integers/

    public static void main(String[] args) {

        int dividend = 10;
        int divisor = 3;
        System.out.println(divideSimple(dividend, divisor));
    }

    public static int divideSimple(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives
         * for the reasons explained above.
         * Also, we count the number of negatives signs. */
        // int negatives = 2;
        int dividendMod = Math.abs(dividend);
        int divis = Math.abs(divisor);

        /* Count how many times the divisor has to be added
         * to get the dividend. This is the quotient. */
        int quotient = 0;
        while (dividendMod - divis >= 0) {
            quotient++;
            dividendMod -= divis;
        }

        quotient = dividend>0==divisor>0?quotient:-quotient;
        return quotient;
    }

    public static int divide(int dividend, int divisor) {
        if (dividend <= Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        int x = 0;
        while(a-b >= 0) {
          while (a - (b << 1 << x) > 0)  {
              x++;
          }
          res += 1<<x;
          a -= b<<x;
        }
        return dividend>0==divisor>=0?res:-res;




//        while(a-b >= 0) {
//         int x = 0;
//         while ((a - (b <<1 <<x))  > 0) {
//             x++;
//         }
//         res += 1 << x;
//         a = a - (b << x);
//        }
//        return (dividend>=0) == (divisor>=0)?res:-res;
    }


}
