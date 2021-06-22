package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

//https://leetcode.com/problems/contains-duplicate-ii/
//        Input: nums = [1,2,3,1], k = 3
//        Output: true
//return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k

public class ContainsDuplicateII_219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}