package com.example.ArrayStrings;

public class JewelsandStones_771 {

//    Input: J = "aA", S = "aAAbbbb"
//    Output: 3
//    https://leetcode.com/problems/jewels-and-stones/

    public static void main(String[] args) {
        String jewel = "aA";
        String stone = "aAAbbbb";
        System.out.println(numJewelsInStones(jewel, stone));
    }

    public static int numJewelsInStones(String J, String S) {
           int[] charSet = new int[128];
           for (char c: S.toCharArray()) {
               charSet[c]++;
           }
           int count = 0;
           for (char c : J.toCharArray()) {
               count += charSet[c];
           }
           return count;
    }
}