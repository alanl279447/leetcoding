package com.example.ArrayStrings;

public class howManyOnesInRange {
    //Solution s = new Solution([0, 1, 1, 1, 0, 0]);
    //s.howManyOnesInRange(0, 3); // should return 3
    //s.howManyOnesInRange(0, 0); // 0
    //s.howManyOnesInRange(3, 5); // 1
    public static void main(String[] args) {
        int nums[] = {0, 1, 1, 1, 0, 0};
        int returnValue = howManyOnesInRange(nums, 0, 3);
        System.out.println("number of 1's: " +howManyOnesInRange(nums, 0, 3));
        System.out.println("number of 1's: " +howManyOnesInRange(nums, 0, 0));
        System.out.println("number of 1's: " +howManyOnesInRange(nums, 3, 5));
    }

    public static int howManyOnesInRange(int[] nums, int start, int end) {
        int count = 0;
        for (int i=start; i<=end; i++) {
           if (nums[i] == 1) count++;
        }
        return count;
    }
}
