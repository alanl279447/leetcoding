package com.example.ArrayStrings;

public class JumpGameII_45 {

//    Input: [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
//    https://leetcode.com/problems/jump-game-ii/

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        int i = 0, level = 0, max = 0;
        while(i <= max) {
            int newMax = max;
            for(; i <= max; i++) {
                newMax = Math.max(newMax, i+nums[i]);
                if(newMax >= nums.length-1) {
                    return level+1;
                }
            }
            max = newMax;
            level++;
        }
        return -1;
    }
}