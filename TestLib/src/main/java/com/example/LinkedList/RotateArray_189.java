package com.example.LinkedList;

public class RotateArray_189 {

//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]
//    https://leetcode.com/problems/rotate-array/

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for (int num:nums) {
            System.out.println(num);
        }
    }

    //1,2,3,4,5,6,7
    //7,6,5,4,3,2,1
    //5,6,7,4,3,2,1
    //5,6,7,1,2,3,4

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseNumbers(nums, 0, nums.length - 1);
        reverseNumbers(nums, 0, k-1);
        reverseNumbers(nums, k, nums.length-1);
    }

    public static void reverseNumbers(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
