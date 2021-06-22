package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class FirstMissingPositive_41 {
//    Input: [1,2,0]
//    Output: 3
//
//    Input: [7,8,9,11,12]
//    Output: 1
//
//    https://leetcode.com/problems/first-missing-positive/

    public static void main(String args[]) {
       int[] input = {3,4,-1,1};
        //int[] input = {1,2,0};
        int res = firstMissingPositive(input);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        boolean oneExit = false;
        for (int num: nums) {
            if (num == 1) {
                oneExit = true;
                break;
            }
        }
        if (!oneExit) {
            return 1;
        }

        for (int i=0; i < nums.length; i++) {
            if (nums[i] <=0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);

            if (index < nums.length) {
                nums[index] = -1 * Math.abs(nums[index]);
            } else {
                nums[0] = -1 * Math.abs(nums[index-1]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return nums.length;
        } else {
            return nums.length+1;
        }
    }
}
