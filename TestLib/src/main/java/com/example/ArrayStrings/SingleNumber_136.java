package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {

//    Input: [4,1,2,1,2]
//    Output: 4
//    https://leetcode.com/problems/single-number/

//    0 ^ N = N   XOR operation
//    N ^ N = 0

    public static void main(String[] args) {
        int[] input = {4,1,2,1,2};
        System.out.println(singleNumber(input));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num:nums) {
            result ^=num;
        }
        return result;
    }
}