package com.example.DynamicProgramming;

public class BurstBalloons_312 {

//    Input: [3,1,5,8]
//    Output: 167
//    Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
//    https://leetcode.com/problems/burst-balloons/

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.print(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
          return 0;
    }

}
