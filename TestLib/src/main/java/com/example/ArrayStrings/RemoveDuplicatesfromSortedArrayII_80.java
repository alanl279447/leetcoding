package com.example.ArrayStrings;

//Given nums = [1,1,1,2,2,3],
//        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//        It doesn't matter what you leave beyond the returned length.
//        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class RemoveDuplicatesfromSortedArrayII_80 {

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,1,2,3,3};
        int returnValue = removeDuplicates(nums);
        System.out.println("Length is: " + returnValue);
        for (int i = 0; i < returnValue; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i =0, twiceCount = 1, len = nums.length;
        for (int j=1; j < len; j++) {
            if (nums[i]==nums[j]) {
                twiceCount++;
            } else {
                twiceCount = 1;
            }
            if (twiceCount <=2) {
               i++;
               nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
