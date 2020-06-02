package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SteppingNumbers_1215 {
//    Input: candidates = [2,3,6,7], target = 7,
//    A solution set is:
//            [
//            [7],
//            [2,2,3]
//            ]
//    https://leetcode.com/problems/combination-sum/
//    Time complexity is O(A^target) where A is a length of candidates array.
//    Space complexity is O(target).

    public static void main(String args[]) {
        int[] input = {2,3,6,7};
        List<List<Integer>> res = combinationSum(input, 7);

        for(List<Integer> re: res) {
            System.out.println(re);
        }
    }

    //backTracking
    public static List<List<Integer>> combinationSumPrac(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackingPrac(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void backtrackingPrac(List<List<Integer>> result, List<Integer> temp, int[] candidate, int remainder, int position) {
        if (remainder < 0) return;
        if (remainder ==0) {
            result.add(temp);
        } else {
            for (int i=position; i < candidate.length; i++) {
                temp.add(candidate[position]);
                System.out.println(temp.toString());
                backtrackingPrac(result, temp, candidate, remainder-candidate[position], i);
                temp.remove(temp.size()-1);
            }
        }

    }



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> temp_list, int[] candidates, int remainder, int start) {
        if (remainder < 0) {
            return;
        }
        if (remainder ==0) {
            res.add(new ArrayList<>(temp_list));
        } else {
            for (int i=start; i < candidates.length; i++) {
                temp_list.add(candidates[i]);
                System.out.println(temp_list.toString());
                backtracking(res, temp_list, candidates, remainder-candidates[i], i);
                temp_list.remove(temp_list.size() -1);
            }
        }
    }

}
