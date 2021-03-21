package com.example.TreesAndGraph;

public class ReverseBits_190 {
//    Input: n = 00000010100101000001111010011100
//    Output:    964176192 (00111001011110000010100101000000)
//    Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
//    so return 964176192 which its binary representation is 00111001011110000010100101000000.
//    https://leetcode.com/problems/reverse-bits/
    public static void main(String[] args) {
        int x = 43261596;
        System.out.print(reverseBits(x));
    }

    public static int reverseBits(int n) {
        int result=0;
        for (int i=0;i<32;i++) {
          result += n&i;
          n = n>>>1;
          if (i < 31) {
              result = result <<= 1;
          }
        }
        return result;
    }
}