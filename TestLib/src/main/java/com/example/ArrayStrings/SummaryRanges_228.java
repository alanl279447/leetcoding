package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {

//    Input:  [0,2,3,4,6,8,9]
//    Output: ["0","2->4","6","8->9"]
//    Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
//    https://leetcode.com/problems/summary-ranges/
//    time complexity 0(n).

    public static void main(String args[]) {
        int[] input = {0, 2, 3, 4, 6, 8, 9};
        List<String> result = summaryRanges(input);
        for (String res : result)
            System.out.println(res);
    }

    //i = 0, j = 0
    //j = i
    //while(i+1) < nums.len i++
    //if (nums[i] == nums[j])

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums==null || nums.length == 0) {
              return result;
          }
        for (int i=0,j=0; j<nums.length;j++) {
            i=j;
            while(j+1<nums.length && nums[j+1]==nums[j]+1) {
                j++;
            }
            String str = null;
            if (nums[i]==nums[j]) {
                str = nums[i]+"";
            } else {
                str=nums[i]+"->"+nums[j];
            }
            result.add(str);
        }
        return result;
    }
}