package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
//    Input: nums = [1,2,3]
//    Output:
//            [
//            [3],
//            [1],
//            [2],
//            [1,2,3],
//            [1,3],
//            [2,3],
//            [1,2],
//            []
//            ]
//    https://leetcode.com/problems/subsets/

//    Time complexity: O(N 2^N)
//    Space complexity: O(N 2^N)

    public static void main(String args[]) {
        int[] input = {1,2,3};
        List<List<Integer>> res = subsets(input);
        for(List<Integer> re: res) {
            System.out.println(re);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
//            if (i >start && nums[i] == nums[i-1]) {
//                continue;
//            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}