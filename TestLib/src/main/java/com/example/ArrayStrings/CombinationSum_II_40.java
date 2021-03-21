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

    public static void main(String args[]) {
//        int[] input = {10,1,2,7,6,1,5};
        int[] input = {1,1,1,2,2};
        List<List<Integer>> res = combinationSum(input, 4);
        for(List<Integer> re: res) {
            System.out.println(re);
        }
    }

    static List<List<Integer>> res = new ArrayList();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList());
        return res;
    }

    public static void dfs(int i, int [] candidates, int target, List<Integer> list){
        if( target == 0){
            res.add(new ArrayList(list));
            return;
        }
        if( target < 0 )  return;
        for(int j = i ; j < candidates.length ; j++ ){
            if( j == i || candidates[j] != candidates[j-1] ){
                list.add(candidates[j]);
                dfs(j+1, candidates, target - candidates[j], list );
                list.remove(list.size()-1);
            }
        }
    }
}