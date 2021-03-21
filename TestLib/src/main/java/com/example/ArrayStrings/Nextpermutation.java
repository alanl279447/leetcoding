package com.example.ArrayStrings;

public class Nextpermutation {

//    https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3012/
    public static void main(String[] args) {
//        int nums[] = {1, 5, 1};
        int nums[] = {1,5,8,4,7,6,5,3,1};
//        nextPermutation(nums);
        nextPermutation(nums);
        for (int i=0; i <nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // find the first decreasing number (index of 4)
    // then find the next largest number  (index of 5)
    // swap with the (4,5)  1,5,8,5,7,6,4,3,1
    //reverse from 5  1,5,8,5,1,3,4,6,7
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
