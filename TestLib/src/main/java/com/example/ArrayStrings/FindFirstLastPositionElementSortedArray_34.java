package com.example.ArrayStrings;

public class FindFirstLastPositionElementSortedArray_34 {

//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]

//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]
//    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        for (int res: result) {
            System.out.println(res);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
       int[] result = new int[2];
       result[0] = findTheLeftRange(nums, target);
       result[1] = findTheRightRange(nums, target);
       return result;
    }

    public static int findTheLeftRange(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int midpoint = start + (end - start)/2;
            if (nums[midpoint] >= target) {
                end = midpoint-1;
            } else {
                start = midpoint+1;
            }
            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }

    public static int findTheRightRange(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int midpoint = start + (end - start)/2;
            if (nums[midpoint] <= target) {
                start = midpoint+1;
            } else {
                end = midpoint-1;
            }
            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }
}