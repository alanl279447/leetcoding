package com.example.ArrayStrings;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ThirdMaximumNumber_414 {

//    Input: [3, 2, 1]
//    Output: 1
//    Explanation: The third maximum is 1.
//    https://leetcode.com/problems/third-maximum-number/

    public static void main(String[] args) {
        int[] nums = {3,2,1, 4, 5};
        System.out.println(thirdMaxPq(nums));
    }

    public static int thirdMax(int[] nums) {
       HashSet<Integer> set  = new HashSet<>();
       for (int num: nums) {
           set.add(num);
           if (set.size() > 3) {
               set.remove(Collections.min(set));
           }
       }
       if (set.size() == 3) {
           return Collections.min(set);
       }
       return Collections.max(set);
    }

    public static int thirdMaxTest(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() < 3)
            return set.last();
        set.remove(set.last());
        set.remove(set.last());
        return set.last(); //return highest
    }

    public static int thirdMaxPq(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (!pq.contains(i)) {
                pq.offer(i);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
