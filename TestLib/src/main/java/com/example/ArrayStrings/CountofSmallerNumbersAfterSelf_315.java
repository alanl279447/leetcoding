package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {
//    Input: nums = [5,2,6,1]
//    Output: [2,1,1,0]
//    Explanation:
//    To the right of 5 there are 2 smaller elements (2 and 1).
//    To the right of 2 there is only 1 smaller element (1).
//    To the right of 6 there is 1 smaller element (1).
//    To the right of 1 there is 0 smaller element.
//    https://leetcode.com/problems/count-of-smaller-numbers-after-self/

    public static void main(String[] args) {
        int[] input = {5,2,6,1};
        List<Integer> res = countSmaller(input);
        for (int re: res) {
            System.out.println(re);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> resList = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = biInsert(resList, nums[i]);
        }
        resList.clear();
        for (int i = 0; i < nums.length; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    public static int biInsert(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m = list.get(mid);
            if (m < target) {
                l = mid + 1;
            }
            else if (m >= target) {
                r = mid - 1;
            }
        }
        list.add(l, target);
        return l;
    }
}