package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II_40 {
//    Input: candidates = [10,1,2,7,6,1,5], target = 8
//    Output:
//            [
//            [1,1,6],
//            [1,2,5],
//            [1,7],
//            [2,6]
//            ]
//    https://leetcode.com/problems/combination-sum-ii/
//in the worst case, our algorithm will exhaust all possible combinations from the input array.
//        Again, in the worst case, let us assume that each number is unique.
//    The number of combination for an array of size NN would be 2^N
//            N i.e. each number is either included or excluded in a combination.
    public static void main(String args[]) {
//        int[] input = {10,1,2,7,6,1,5};
        int[] input = {1, 1, 1, 2, 2};
        List<List<Integer>> res = combinationSum2(input, 4);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
