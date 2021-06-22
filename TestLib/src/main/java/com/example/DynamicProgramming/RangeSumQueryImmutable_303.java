package com.example.DynamicProgramming;

public class RangeSumQueryImmutable_303 {

//    Given nums = [-2, 0, 3, -5, 2, -1]
//    sumRange(0, 2) -> 1
//    sumRange(2, 5) -> -1
//    sumRange(0, 5) -> -3
//    https://leetcode.com/problems/range-sum-query-immutable/

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,0);
        System.out.print(param_1);
    }

    static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

}
