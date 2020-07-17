package com.example.ArrayStrings;

public class ThirdMaximumNumber_414 {

//    Input: [1,3,5,6], 5
//    Output: 2
//    https://leetcode.com/problems/search-insert-position/

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5));
    }

    public static int searchInsert(int[] nums, int target) {

        if (nums==null || nums.length==0) {
            return -1;
        }
        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid=left+(right-left)/2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]>target) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}
