package com.example.ArrayStrings;

public class ReverseInteger_7 {

//    Input: 123
//    Output: 321
//
//    Input: -123
//    Output: -321
//
//    https://leetcode.com/problems/reverse-integer/
//     -2,147,483,648 (-231) to 2,147,483,647 (231-1)

    public static void main(String[] args) {
        int input = Integer.MIN_VALUE;
        System.out.println(reverse(input));
    }

    public static int reverseF(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - x % 10) < res * 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return sign * res;
    }



    public static int reverse(int x) {
        int pop = 0;
        int rev = 0;

        while(x !=0) {
            pop = x%10;
            x =x/10;

            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && pop >7)  // (2^31-1)
                return 0;
            if (rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && pop <-8)
                return 0;
            rev = rev*10+pop;
        }
        return rev;
    }
}
