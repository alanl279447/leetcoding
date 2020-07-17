package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumber_1429 {

//    Input:
//            ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
//            [[[2,3,5]],[],[5],[],[2],[],[3],[]]
//    Output:
//            [null,2,null,2,null,3,null,-1]
//    Explanation:
//    FirstUnique firstUnique = new FirstUnique([2,3,5]);
//firstUnique.showFirstUnique(); // return 2
//firstUnique.add(5);            // the queue is now [2,3,5,5]
//firstUnique.showFirstUnique(); // return 2
//firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//firstUnique.showFirstUnique(); // return 3
//firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//firstUnique.showFirstUnique(); // return -1
//    https://leetcode.com/problems/first-unique-number/

    public static void main(String args[]) {
        int[] nums = {2,3,5};
        FirstUnique obj = new FirstUnique(nums);
        int param_1 = obj.showFirstUnique();
        System.out.println(param_1);
        obj.add(5);
        int param_2 = obj.showFirstUnique();
        System.out.println(param_2);
        obj.add(2);
        int param_3 = obj.showFirstUnique();
        System.out.println(param_3);
        obj.add(3);
        int param_4 = obj.showFirstUnique();
        System.out.println(param_4);
    }

    static class FirstUnique {
        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        public FirstUnique(int[] nums) {
            for (int x : nums)
                add(x);
        }
        public int showFirstUnique() {
            while (!q.isEmpty() && freq.get(q.peek()) > 1)
                q.poll();
            return q.isEmpty() ? -1 : q.peek();
        }
        public void add(int value) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
            q.offer(value);
        }
    }

}
