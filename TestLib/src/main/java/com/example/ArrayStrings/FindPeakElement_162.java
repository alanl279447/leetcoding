package com.example.ArrayStrings;

public class FindPeakElement_162 {

//    Input: nums = [1,2,3,1]
//    Output: 2
//    Explanation: 3 is a peak element and your function should return the index number 2.
//    https://leetcode.com/problems/find-peak-element/

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,7};
        int peakIndex = findPeakElement(nums);
        System.out.println(peakIndex);
    }

    //modified binary search
    //pass the left element
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}