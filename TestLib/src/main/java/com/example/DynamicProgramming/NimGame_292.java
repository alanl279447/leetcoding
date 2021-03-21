package com.example.DynamicProgramming;

public class NimGame_292 {

//    https://leetcode.com/problems/nim-game/
//    Input: n = 4
//    Output: false
//    Explanation: These are the possible outcomes:
//            1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
//2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
//3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
//    In all outcomes, your friend wins.

    public static void main(String[] args) {
        boolean res = canWinNim(4);
        System.out.println(res);
    }

    public static boolean canWinNim(int n) {
      return n % 4 != 0;
    }

}
