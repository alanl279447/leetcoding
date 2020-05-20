package com.example.ArrayStrings;

import java.util.Arrays;

public class UglyNumber_263 {
//    Input: 6
//    Output: true
//    Explanation: 6 = 2 × 3
//    https://leetcode.com/problems/ugly-number/

    public static void main(String args[]) {
        boolean result = isUgly( 14);
        System.out.println(result);
    }

    public static boolean isUgly(int num) {
       if (num == 0) return false;
       if (num == 1) return true;

       while(num%2==0) num=num/2;
       while(num%3==0) num=num/3;
       while(num%5==0) num=num/5;

       return num==1;
    }
}
