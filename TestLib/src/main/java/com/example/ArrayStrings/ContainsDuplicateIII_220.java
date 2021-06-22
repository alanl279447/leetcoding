package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/contains-duplicate-iii/
//        Input: nums = [1,2,3,1], k = 3, t = 0
//        Output: true
//        if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

public class ContainsDuplicateIII_220 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    //time complexity 0(n logk)
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
       for (int i = 0; i < nums.length; i++) {
           Long floor  = set.floor((long) nums[i]);   //floor is nearest to num (less than or equal)
           if (floor != null && nums[i]-floor <=t) return true;

           Long ceiling = set.ceiling((long)nums[i]);
           if (ceiling != null && ceiling - nums[i] <= t) return true;

           set.add((long)nums[i]);
           if (set.size() > k) {
               set.remove(nums[i-k]);
           }
       }
       return false;
    }
}