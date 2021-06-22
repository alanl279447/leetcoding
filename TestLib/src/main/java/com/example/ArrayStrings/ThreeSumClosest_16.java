package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//        Given array nums = [-1, 2, 1, -4], and target = 1.
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//        https://leetcode.com/problems/3sum-closest/
//        0(n^2)

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4};
        System.out.println("Start main " +threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[nums.length-1];

       for (int i=0; i+2<nums.length; i++) {
         int start = i+1, end  = nums.length-1;
         while (start < end) {
             int sum = nums[i]+nums[start]+nums[end];
             if (sum > target) {
                 end--;
             } else if (sum < target){
                 start++;
             } else {
                 return sum;
             }
             if(Math.abs(sum-target) < Math.abs(result-target)) {
                 result = sum;
             }
         }
       }
       return result;
    }
}
