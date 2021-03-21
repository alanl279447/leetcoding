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
        //String result = frequencySort("aabccdddee");
        String result = frequencySort("tree");
        System.out.println(result);
    }

    public static String frequencySort(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new int[]{1, i});
            else {
                int[] freqAndSeq = map.get(c);
                freqAndSeq[0]++;
                map.put(c, freqAndSeq);
            }
        }

        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
                a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] :
                        b.getValue()[0] - a.getValue()[0]);

        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> e = pq.poll();
            for (int i = 0; i < e.getValue()[0]; i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
