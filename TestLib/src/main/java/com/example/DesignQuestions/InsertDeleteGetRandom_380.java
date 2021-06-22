package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom_380 {
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

//    map<Int, Int>   value, list index
//    list<Int>

    public static class RandomizedSet {
        Map<Integer, Integer> map = null;
        List<Integer> list = null;
        Random random = null;

        /** Initialize your data structure here. */
        public RandomizedSet() {
             map = new HashMap<>();
             list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
          if (map.containsKey(val)) {  //O(1)
              return false;
          }
          map.put(val, list.size());    //O(1)
          list.add(val);
          return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
           if(!map.containsKey(val)) {
               return false;
           }
           int lastElement = list.get(list.size()-1);
           int idx = map.get(val);

           list.set(idx, lastElement);
           map.put(lastElement, idx);

           list.remove(list.size()-1);
           map.remove(val);
           return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
           return list.get(random.nextInt(list.size()));
        }
    }
}