package com.example.ArrayStrings;

public class NthDigit_400 {
//    https://leetcode.com/problems/nth-digit/
//    Input: 11
//    Output:0
//    Explanation:
//    The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12 ... is a 0, which is part of the number 10.

//1 ~ 9 include 9 one digit number;
//10 ~ 99 include 90 two digits number;
//100 ~ 999 include 900 three digits number;
//1000 ~ 9999 include 9000 four digits number;
//
//len is how many digits:1 or 2 or 3 ..., range is 9 or 90 or 900 ...
    public static void main(String[] args) {
        System.out.println(findNthDigit(15));
    }
    public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));

    }
}