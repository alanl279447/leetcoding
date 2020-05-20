package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_test {
//    // Init an empty set.
//    RandomizedSet randomSet = new RandomizedSet();
//// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomSet.insert(1);
//// Returns false as 2 does not exist in the set.
//randomSet.remove(2);
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//randomSet.insert(2);
//// getRandom should return either 1 or 2 randomly.
//randomSet.getRandom();
//// Removes 1 from the set, returns true. Set now contains [2].
//randomSet.remove(1);
//// 2 was already in the set, so return false.
//randomSet.insert(2);
//// Since 2 is the only number in the set, getRandom always return 2.
//randomSet.getRandom();
//    https://leetcode.com/problems/insert-delete-getrandom-o1/

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        System.out.println(param_1);
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }

    public static class RandomizedSet {


        Map<Integer, Integer> map = null;
        List<Integer> lists = null;
        Random random = null;

        public RandomizedSet() {
           map = new HashMap<>();
           lists = new ArrayList<>();
           random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
           if (map.containsKey(val)) {
               return true;
           }
           map.put(val, lists.size());
           lists.add(lists.size(), val);
           return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
           if (!map.containsKey(val)) {
              return false;
           }

           int elementIndexToRemove = map.get(val);  //index in map for value...
           int lastElement = lists.get(lists.size()-1);

           map.put(lastElement, elementIndexToRemove);
           lists.set(elementIndexToRemove, lastElement);

           map.remove(val);
           lists.remove(lists.size()-1);
           return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
           return lists.get(random.nextInt(lists.size()-1));
        }
    }

}