package com.example.ArrayStrings;

public class JumpGame_55 {

//    Input: nums = [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//    https://leetcode.com/problems/jump-game/

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length-1;
        for (int i=nums.length-1; i >=0; i--) {
            if (i+nums[i]>=lastGoodIndex) {
                lastGoodIndex=i;
            }
        }
        return lastGoodIndex==0;
    }
}