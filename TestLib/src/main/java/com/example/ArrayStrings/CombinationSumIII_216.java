package com.example.ArrayStrings;

//import java.util.List;
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Explanation:
//        1 + 2 + 4 = 7
//        There are no other valid combinations.
//        https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public static void main(String args[]) {
        int[] input = {2,3,6,7};
        List<List<Integer>> res = combinationSum3(3, 9);
        for(List<Integer> re: res) {
            System.out.println(re);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> temp, int start, int k, int target) {
        if (temp.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if (target < 0 || temp.size() > k) {
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                helper(result, temp, i+1, k, target-i);
                temp.remove(temp.size()-1);
            }
        }
    }
}