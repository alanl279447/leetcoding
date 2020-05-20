package com.example.ArrayStrings;

import java.util.Stack;

public class ReverseInteger_7 {

//    Input: 123
//    Output: 321
//
//    Input: -123
//    Output: -321
//
//    https://leetcode.com/problems/reverse-integer/

    public static void main(String[] args) {
        int input = -123;
        System.out.println(reverse(input));
    }

    public static int reverse(int x) {
        int pop = 0;
        int rev = 0;

        while(x !=0) {
            pop = x%10;
            x =x/10;

            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE && pop >7)
                return 0;
            if (rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE && pop <-8)
                return 0;
            rev = rev*10+pop;
        }
        return rev;
    }

}
