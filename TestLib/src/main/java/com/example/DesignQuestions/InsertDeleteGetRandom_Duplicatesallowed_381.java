package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
        ArrayList<Integer> result;
        HashMap<Integer, LinkedHashSet<Integer>> map;

        public RandomizedCollection() {
            result = new ArrayList<Integer>();
            map = new HashMap<Integer, LinkedHashSet<Integer>>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            // Add item to map if it doesn't already exist.
            boolean alreadyExists = map.containsKey(val);
            if(!alreadyExists) {
                map.put(val, new LinkedHashSet<Integer>());
            }
            map.get(val).add(result.size());
            result.add(val);
            return !alreadyExists;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            // Get arbitary index of the ArrayList that contains val
            LinkedHashSet<Integer> valSet = map.get(val);
            int indexToReplace = valSet.iterator().next();

            // Obtain the set of the number in the last place of the ArrayList
            int numAtLastPlace = result.get(result.size() - 1);
            LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);

            // Replace val at arbitary index with very last number
            result.set(indexToReplace, numAtLastPlace);

            // Remove appropriate index
            valSet.remove(indexToReplace);

            // Don't change set if we were replacing the removed item with the same number
            if(indexToReplace != result.size() - 1) {
                replaceWith.remove(result.size() - 1);
                replaceWith.add(indexToReplace);
            }
            result.remove(result.size() - 1);

            // Remove map entry if set is now empty, then return
            if(valSet.isEmpty()) {
                map.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            // Get linearly random item
            return result.get((int)(Math.random() * result.size()));
        }
    }

}