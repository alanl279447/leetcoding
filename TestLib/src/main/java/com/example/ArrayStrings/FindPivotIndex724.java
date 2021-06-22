package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPivotIndex724 {
//    Input:
//    nums = [1, 7, 3, 6, 5, 6]
//    Output: 3
//    Explanation:
//    The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
//    Also, 3 is the first index where this occurs.
//    https://leetcode.com/problems/find-pivot-index/

    // totalSum = 28
    // left = 1, 8,
    // totalSum - leftSum - nums[i] = leftSum
    // 28 - 11 - 6 = 11
    public static void main(String args[]) {
//        int[] input = {1,7,3,6,5,6};
        int[] input = {-1,-1,-1,0,1,1};
        int res = pivotIndex(input);
        System.out.println(res);
    }

    public static int pivotIndex(int[] nums) {
       int totalSum = 0, leftSum =0;

       for (int num: nums) {
           totalSum +=num;
       }
       for (int i=0; i < nums.length; i++) {
           if (leftSum == totalSum-leftSum-nums[i]) {
               return i;
           }
           leftSum +=nums[i];
       }
       return -1;
    }
}
