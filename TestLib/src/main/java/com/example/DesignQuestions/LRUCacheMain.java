package com.example.DesignQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//import static sun.misc.Version.println;

public class LRUCacheMain {

//    LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4

    public static void main(String[] args) {
        int capacity = 4;
        LRUCache obj = new LRUCache(capacity);
        obj.put(1, 1);
        int param_1 = obj.get(1);
        System.out.println(param_1);
    }

    public static class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity = 0;
        Map<Integer, Integer> cache = null;
        public LRUCache(int capacity) {
          super(capacity, 0.75F, true);
          capacity = capacity;
        }

        public int get(int key) {
           return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
           super.put(key, value);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
              return size() > capacity;
        }
    }
}
