package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom_Duplicatesallowed_381 {
//    // Init an empty collection.
//    RandomizedCollection collection = new RandomizedCollection();
//
//// Inserts 1 to the collection. Returns true as the collection did not contain 1.
//collection.insert(1);
//
//// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
//collection.insert(1);
//
//// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
//collection.insert(2);
//
//// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
//collection.getRandom();
//
//// Removes 1 from the collection, returns true. Collection now contains [1,2].
//collection.remove(1);
//
//// getRandom should return 1 and 2 both equally likely.
//collection.getRandom();
//    https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        boolean param_1 = collection.insert(1);
        System.out.println(param_1);
        boolean param_4 = collection.insert(1);
        System.out.println(param_4);
        boolean param_2 = collection.remove(2);
        System.out.println(param_2);
        int param_3 = collection.getRandom();
        System.out.println(param_3);
    }

    public static class RandomizedCollection {
        ArrayList<Integer> lst;
        HashMap<Integer, Set<Integer>> idxMap;
        Random rand = new Random();
        /** Initialize your data structure here. */

        public RandomizedCollection() {
            lst = new ArrayList<>();
            idxMap = new HashMap<>();
        }

//        lst  list<Integer
//        map <val>  index of list indexes
        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (!idxMap.containsKey(val)) idxMap.put(val, new LinkedHashSet<Integer>());
            idxMap.get(val).add(lst.size());
            lst.add(val);
            return idxMap.get(val).size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!idxMap.containsKey(val) || idxMap.get(val).size() == 0) return false;
            int remove_idxMap = idxMap.get(val).iterator().next();
            idxMap.get(val).remove(remove_idxMap);
            int last = lst.get(lst.size() - 1);
            lst.set(remove_idxMap, last);
            idxMap.get(last).remove(lst.size() - 1);
            idxMap.get(last).add(remove_idxMap);

            lst.remove(lst.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return lst.get(rand.nextInt(lst.size()));
        }
    }
}