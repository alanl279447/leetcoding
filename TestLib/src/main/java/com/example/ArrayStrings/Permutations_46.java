package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
//    Input: [1,2,3]
//    Output:
//            [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//            ]
//    https://leetcode.com/problems/permutations/
//    time complexity 0(n!)
//    For the complexity, I think you can explain in this way: in the first level of the tree,
//    you have N options and for each of the option, you have N-1 option, and for each of these N-1 options, you have another N-2 options,
//    so putting them together you would end up N*(N-1)*(N-2).... = N!

    public static void main(String[] args) {
        int[] board = {1,2,3};
        List<List<Integer>> result = permute(board);
        for (List<Integer> res: result) {
            System.out.println(res);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
         if (temp.size() == nums.length) {
             list.add(new ArrayList<>(temp));
         } else {
             for (int i = 0; i < nums.length; i++) {
                 if (temp.contains(nums[i])) continue;
                 temp.add(nums[i]);
                 backtrack(list, temp, nums);
                 temp.remove(temp.size()-1);
             }
         }
    }

//    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//        if(tempList.size() == nums.length){
//            list.add(new ArrayList<>(tempList));
//        } else{
//            for(int i = 0; i < nums.length; i++){
//                if(tempList.contains(nums[i])) continue; // element already exists, skip
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }

}
