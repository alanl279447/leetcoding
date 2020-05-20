package com.example.ArrayStrings;

public class NumArray_RangeSum {

    private int[] sums = null;
    public NumArray_RangeSum(int[] nums) {
       sums = new int[nums.length];
       for (int i=1; i < nums.length; i++) {
           sums[i] = sums[i-1] + nums[i];
       }
    }

    public int sumRange(int i, int j) {
       int sum = sums[j] - sums[i];

       return sum;
    }
}
