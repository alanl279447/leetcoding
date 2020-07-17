package com.example.ArrayStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {
//    Input:
//            "cccaaa"
//    Output:
//            "cccaaa"
//    Explanation:
//    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//    Note that "cacaca" is incorrect, as the same characters must be together.
//    https://leetcode.com/problems/sort-characters-by-frequency/

    public static void main(String args[]) {
        String result = frequencySort("aabccdddee");
        System.out.println(result);
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry entry = pq.poll();
            for (int i=0; i<(int)entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
