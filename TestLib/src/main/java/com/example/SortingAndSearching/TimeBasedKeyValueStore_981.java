package com.example.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

//    Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//    Output: [null,null,"bar","bar",null,"bar2","bar2"]
//    Explanation:
//    TimeMap kv;
//kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
//kv.get("foo", 1);  // output "bar"
//kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
//kv.set("foo", "bar2", 4);
//kv.get("foo", 4); // output "bar2"
//kv.get("foo", 5); //output "bar2"
//    https://leetcode.com/problems/time-based-key-value-store/

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[][] nums1 = {{1,3}, {-2,2}};

        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        String param_2 = obj.get("foo",3);
        System.out.print(param_2);    //bar

        obj.set("foo", "bar2", 4);
        param_2 = obj.get("foo", 4);
        System.out.print(param_2);    //bar2

        param_2 = obj.get("foo", 5);
        System.out.print(param_2);  //bar2
    }


    public static class TimeMap {

        Map<String, TreeMap<Integer, String>> map = null;
        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
              if (map.get(key) == null) {
                  map.put(key, new TreeMap<>());
              }
              map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
                if (map.get(key) == null) {
                    return "";
                }
                TreeMap<Integer, String> treeMap = map.get(key);
                    Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
                    String value = entry != null ? entry.getValue(): "";

                return value;
        }
    }
}
