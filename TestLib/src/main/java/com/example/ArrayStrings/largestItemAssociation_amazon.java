package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class largestItemAssociation_amazon {

//[Item1, Item2],
//[Item3, Item4],
//[Item4, Item5]

//soln: [Item3, Item4, Item5]
//Explanation:
//There are two item association groups:
//group1: [Item1, Item2]
//group2: [Item3,Item4,Item5]
//In the available associations, group2 has the largest association. So, the output is [Item3, Item4, Item5].
//https://leetcode.com/discuss/interview-question/782606/

//    steps
//    Create adjacency map from edge list
//    For each node, find connected nodes (neighbors) with help of adjacency map (and that should be similar to Number of Islands)
//    Throw connected nodes into a maxHeap with custom comparator, where we sort lexicographically, when the size is same. MaxHeap will contain a List of strings
//    Return maxHeap root.
    public static void main(String[] args) {
        List<PairString> pairs = Arrays.asList( //
                new PairString("item1", "item2"), //
                new PairString("item3", "item4"), //
                new PairString("item4", "item5") //
        );
        System.out.println(largestItemAssociation(pairs));
    }

    //map of string, set<String>
    //pq to sort based on length
    //get the top on queue
    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        if (itemAssociation == null || itemAssociation.size() == 0) {
            return new ArrayList<>();
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (PairString pair : itemAssociation) {
            Set<String> set = map.getOrDefault(pair.first, new TreeSet<>());
            set.add(pair.first);
            set.add(pair.second);
            set.addAll(map.getOrDefault(pair.second, new TreeSet<>()));
            map.put(pair.first, set);
            map.put(pair.second, set);
        }
        Set<String> checked = new HashSet<>();
        PriorityQueue<List<String>> pq = new PriorityQueue<>((l1, l2)
                -> (l1.size() != l2.size() ? l2.size() - l1.size() : l1.get(0).compareTo(l2.get(0))));
        for (String item : map.keySet()) {
            if (checked.contains(item)) {
                continue;
            }
            pq.add(new ArrayList<>(map.get(item)));
            checked.addAll(map.get(item));
        }
        return pq.remove();
    }

    static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
