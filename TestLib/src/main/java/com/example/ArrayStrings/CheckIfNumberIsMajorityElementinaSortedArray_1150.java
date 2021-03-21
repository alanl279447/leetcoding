package com.example.ArrayStrings;

//        Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
//        Output: true
//        Explanation:
//        The value 5 appears 5 times and the length of the array is 9.
//        Thus, 5 is a majority element because 5 > 9/2 is true.
//        https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
public class CheckIfNumberIsMajorityElementinaSortedArray_1150 {
    public static void main(String[] args) {
        int[] nums = {2,4,5,5,5,5,5,6,6};
        System.out.println("Longest subString is: "+isMajorityElement(nums, 5));
    }

    //use binary search to find the first occurance
    // first + len/2 == target, then return true.
    public static boolean isMajorityElement(int[] nums, int target) {

        int first = binarySearch(nums, target);
        int firstNBy2Sum = first + nums.length/2;
        if (firstNBy2Sum < nums.length && nums[firstNBy2Sum] == target) {
            return true;
        }
        return false;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <    right) {
            int midpt = left+ (right-left)/2;
            if (nums[midpt] < target) {
                left = midpt+1;
            } else {
                right = midpt;
            }
        }
        return left;
    }

}
