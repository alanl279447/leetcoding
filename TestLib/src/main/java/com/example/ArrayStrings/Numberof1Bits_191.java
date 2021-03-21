package com.example.ArrayStrings;

//https://leetcode.com/problems/number-of-1-bits/
//        Input: n = 00000000000000000000000000001011
//        Output: 3
//        Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

public class Numberof1Bits_191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
             if ((n&1) == 1) {
                 count++;
             }
             n = n >>>1;
        }
        return count;
    }
}