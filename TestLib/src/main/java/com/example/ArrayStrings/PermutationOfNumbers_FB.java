package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationOfNumbers_FB {

//    https://leetcode.com/discuss/interview-question/1162056/Facebook-or-onsite-or-E4-or-USA

    public static void main(String[] args) {
        int[] input = {0, 1, 4, 3, 6};
        boolean res = checkIfPermutation(input);
        System.out.println(res);
    }

    public static boolean checkIfPermutation(int[] nums) {
           Set<Integer> set = new HashSet<>();
           int maxElem = 0;

           for (int num: nums) {
               set.add(num);
               if (num > maxElem) {
                   maxElem = num;
               }
           }
           return set.size() == maxElem-1 ? true: false;
    }
}