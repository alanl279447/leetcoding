package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

//    Input: [1,1,2]
//    Output:
//            [
//            [1,1,2],
//            [1,2,1],
//            [2,1,1]
//            ]
//    https://leetcode.com/problems/permutations-ii/

    public static void main(String[] args) {
        int[] board = {1,1,2};
        List<List<Integer>> result = permuteUnique(board);
        for (List<Integer> res: result) {
            System.out.println(res);
        }
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }

//    The difficulty is to handle the duplicates.
//    With inputs as [1a, 1b, 2a],
//    If we don't handle the duplicates, the results would be: [1a, 1b, 2a], [1b, 1a, 2a]...,
//    so we must make sure 1a goes before 1b to avoid duplicates
//    By using nums[i-1]==nums[i] && !used[i-1], we can make sure that 1b cannot be choosed before 1a
//    https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}