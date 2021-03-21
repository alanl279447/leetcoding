package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges_163 {
//    Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//    Output: ["2", "4->49", "51->74", "76->99"]
//    https://leetcode.com/problems/missing-ranges/

    public static void main(String args[]) {
        int[] nums = {0, 1, 3, 50, 75};
        //int[] nums = {};
        List<String> result  = findMissingRanges(nums, 0,99);
        for (String res:result)
          System.out.println(res);
    }

    //0,1,3,50,75      0, 99
    // i==0 0  -  1    lower > higher return
    //1+1  3-1   2,2  2
    //3+1  50-1  4->49
    //50+1  75-1  51->74
    //i==n 76     99    76-99
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
