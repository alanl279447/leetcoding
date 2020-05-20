package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
//    Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//    Output: ["2", "4->49", "51->74", "76->99"]
//    https://leetcode.com/problems/missing-ranges/

    public static void main(String args[]) {

        int[] nums = {0, 1, 3, 50, 75};
        List<String> result  = findMissingRanges(nums, 0,99);
        for (String res:result)
          System.out.println(res);
    }

    public static List<String> findMissingRangesPrac(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        for (int i=0; i < nums.length; i++) {
         int lt = i==0?lower:nums[i-1]+1;
         int gt = i==nums.length?upper:nums[i]-1;
         addRangePrac(result, lt, gt);
        }
        return result;
    }

    public static void addRangePrac(List<String> result, int lower, int higher) {
        if (lower > higher) {
            return;
        }
        if (lower==higher) {
            result.add(String.valueOf(lower));
        } else {
            result.add(lower+"->" +higher);
        }
    }




    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        if(nums == null) return list;
        int n = nums.length;
        for(int i = 0; i <= n; i++) {
            int lt = (i == 0) ? lower : nums[i - 1] + 1;
            int gt = (i == n) ? upper : nums[i] - 1;
            addRange(list, lt, gt);
        }
        return list;
    }
    private static void addRange(List<String> list, int lo, int hi) {
        if(lo > hi) return;
        else if(lo == hi) list.add(String.valueOf(lo));
        else list.add(lo + "->" + hi);
    }
}
