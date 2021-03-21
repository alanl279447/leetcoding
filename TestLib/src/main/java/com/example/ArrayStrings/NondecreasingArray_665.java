package com.example.ArrayStrings;

import java.util.LinkedList;
import java.util.List;

public class NondecreasingArray_665 {
//    Input: nums = [4,2,3]
//    Output: true
//    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//    https://leetcode.com/problems/non-decreasing-array/
    public static void main(String[] args) {
        int[] A = {4,2,3};
        System.out.println(checkPossibility(A));
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1;
    }
}