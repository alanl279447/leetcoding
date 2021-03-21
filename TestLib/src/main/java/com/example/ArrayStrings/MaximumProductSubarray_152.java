package com.example.ArrayStrings;

public class MaximumProductSubarray_152 {

//     contiguous subarray within an array
//    Input: [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.
//    https://leetcode.com/problems/maximum-product-subarray/

    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
      if (nums == null) return 0;
      int currentMin = nums[0]; //2
      int currentMax = nums[0]; //2
      int finalValue = nums[0]; //2

      for (int i=1; i < nums.length; i++) {
          int temp = currentMax;
          currentMax = Math.max(Math.max(currentMax*nums[i], currentMin*nums[i]), nums[i]); //6
          currentMin = Math.min(Math.min(temp*nums[i], currentMin*nums[i]), nums[i]); //2

          if (currentMax > finalValue) {
              finalValue = currentMax;
          }
      }
      return finalValue;
    }

}
