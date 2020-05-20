package com.example.ArrayStrings;

public class duplicateFromSortedArray {

    public static void main(String[] args) {
        int nums[] = {-4, -1, -1, 0, 1, 2};  //-4, -4, 2, 3
        int returnValue = removeDuplicates(nums);
        System.out.println("Length is: " + returnValue);
        for (int i = 0; i < returnValue; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
