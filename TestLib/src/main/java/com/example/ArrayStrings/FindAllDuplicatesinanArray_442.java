package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray_442 {

//    Input:
//            [4,3,2,7,8,2,3,1]
//    Output:
//            [2,3]
//    https://leetcode.com/problems/find-all-duplicates-in-an-array/

    public static void main(String args[]) {
        int[] input = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDuplicates(input);

        for(Integer re: res)
          System.out.println(re);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> newList = new ArrayList<Integer>();     // creating a new List
        for(int i=0;i<nums.length;i++){
            int index =Math.abs(nums[i]);             // Taking the absolute value to find index
            if(nums[index-1] >0){
                nums[index-1] = - nums[index-1];
            }else{
                // If it is not greater than 0 (i.e) negative then the number is a duplicate
                newList.add(Math.abs(nums[i]));
            }
        }
        return newList;
    }

//    public static List<Integer> findDuplicates(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        List<Integer> result = new ArrayList<>();
//
//        for (int num: nums) {
//            if (set.contains(num)){
//                result.add(num);
//            } else {
//                set.add(num);
//            }
//        }
//        return result;
//    }

}
