package com.example.ArrayStrings;

public class PeakIndexMountainArray_852 {

//    Input: [0,1,0]
//    Output: 1
//    https://leetcode.com/problems/peak-index-in-a-mountain-array/

    public static void main(String[] args) {
        int[] nums = {0,2,1,0};
        int peakIndex = findPeakElement(nums);
        System.out.println(peakIndex);
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length < 1) return 0;
        int index = findPeak(nums, 0, nums.length-1);
       return index;
    }

    public static int findPeak(int[] nums, int left, int right) {
        if (left >=right) return left;
        int midpoint = left + (right-left)/2;
        if (nums[midpoint] < nums[midpoint+1]) {
           return  findPeak(nums, midpoint+1, right);
        }
        return findPeak(nums, left, midpoint);
    }
}
