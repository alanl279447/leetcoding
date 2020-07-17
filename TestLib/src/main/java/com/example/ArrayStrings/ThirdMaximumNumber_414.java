package com.example.ArrayStrings;

import java.util.TreeSet;

public class ThirdMaximumNumber_414 {

//    Input: [3, 2, 1]
//    Output: 1
//    Explanation: The third maximum is 1.
//    https://leetcode.com/problems/third-maximum-number/

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {

      return 0;
    }



    public static int thirdMaxTest(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() < 3)
            return set.last();
        set.remove(set.last());
        set.remove(set.last());
        return set.last(); //return highest
    }
}
