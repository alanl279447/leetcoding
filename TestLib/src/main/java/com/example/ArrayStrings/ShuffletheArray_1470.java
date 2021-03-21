package com.example.ArrayStrings;

public class ShuffletheArray_1470 {

//    Input: nums = [2,5,1,3,4,7], n = 3
//    Output: [2,3,5,4,1,7]
//    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
//    https://leetcode.com/problems/shuffle-the-array/

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        System.out.println(shuffle(nums, 3));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        for(int i=0; i< nums.length; i++) {
            result[i] = i %2 == 0 ? nums[i/2] : nums[n+i/2];
        }
        return result;
    }
}