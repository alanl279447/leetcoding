package com.example.ArrayStrings;

//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
//        find the one that is missing from the array.
//        For example, Given nums = [0, 1, 3] return 2. (Of course, you can do this by math.)
//https://leetcode.com/problems/missing-number/
//        =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
//        =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
//        =0∧0∧0∧0∧2
//        =2​
public class MissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {0,1,3};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i=0; i < nums.length;i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}