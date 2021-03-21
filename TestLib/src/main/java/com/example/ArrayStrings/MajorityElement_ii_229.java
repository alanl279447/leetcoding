package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_ii_229 {
//    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//    Follow-up: Could you solve the problem in linear time and in O(1) space?
//    https://leetcode.com/problems/majority-element-ii/
    public static void main(String[] args) {
        int[] input = {3,2,3};
        List<Integer> result = majorityElement(input);
        for (Integer res: result)
            System.out.println(res);
    }

    public static List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;

        int count1 = 0;
        int count2 = 0;

        for (int num: nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 ==0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // 2nd pass
        List result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int n: nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);

        return result;
    }

}
