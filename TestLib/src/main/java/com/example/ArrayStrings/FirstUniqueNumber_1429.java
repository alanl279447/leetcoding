package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        int param_1 = obj.showFirstUnique();   //2
        System.out.println(param_1);
        obj.add(5);
        int param_2 = obj.showFirstUnique();  //2
        System.out.println(param_2);
        obj.add(2);
        int param_3 = obj.showFirstUnique();   //3
        System.out.println(param_3);
        obj.add(3);
        int param_4 = obj.showFirstUnique();   //-1
        System.out.println(param_4);
    }

//    LinkedHashSet         | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Hash Table + Linked List

    static class FirstUnique {
        private Set<Integer> setQueue = new LinkedHashSet<>();
        private Map<Integer, Boolean> isUnique = new HashMap<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                this.add(num);
            }
        }

        public int showFirstUnique() {
            // If the queue contains values, we need to get the first one from it.
            // We can do this by making an iterator, and getting its first item.
            if (!setQueue.isEmpty()) {
                return setQueue.iterator().next();
            }
            return -1;
        }

        public void add(int value) {
            // Case 1: This value is not yet in the data structure.
            // It should be ADDED.
            if (!isUnique.containsKey(value)) {
                isUnique.put(value, true);
                setQueue.add(value);
                // Case 2: This value has been seen once, so is now becoming
                // non-unique. It should be REMOVED.
            } else if (isUnique.get(value)) {
                isUnique.put(value, false);
                setQueue.remove(value);
            }
        }
    }

}
