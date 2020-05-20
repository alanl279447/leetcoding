package com.example.ArrayStrings;

public class FindPeakElement_162 {

//    Input: nums = [1,2,3,1]
//    Output: 2
//    Explanation: 3 is a peak element and your function should return the index number 2.
//    https://leetcode.com/problems/find-peak-element/

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int peakIndex = findPeakElement(nums);
        System.out.println(peakIndex);
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            if (start == end) {
                return start;
            }
            int midpoint = start + (end-start)/2;
            if(nums[midpoint] > nums[midpoint+1]) {
                end = midpoint;
            } else {
                start = midpoint+1;
            }
        }
        return start;
    }
}
