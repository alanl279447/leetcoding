package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesinanArray_test_442 {

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


    public static List<Integer> findDuplicates(int[] input) {
         List<Integer> result =  new ArrayList<>();
         if (input.length <1) return result;

         for (int i=0; i< input.length; i++) {
              int index = Math.abs(input[i]);
              if (input[index -1] < 0) {
                  result.add(Math.abs(input[i]));
              } else {
                  input[index-1] *= -1;
              }
         }
         for (int res: result) {
             if (res < 0) {
                 res *=-1;
             }
         }
         return result;
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
