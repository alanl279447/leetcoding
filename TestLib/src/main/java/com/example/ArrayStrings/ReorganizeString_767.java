package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString_767 {
//    Input: S = "aab"
//    Output: "aba"
//    https://leetcode.com/problems/reorganize-string/

    public static void main(String args[]) {
        String result = reorganizeString("aab");
        System.out.println(result);
    }

    public static String reorganizeString(String S) {
           Map<Character, Integer> map = new HashMap<>();
           char[] chars = S.toCharArray();
           for (char c: chars) {
               map.put(c, map.getOrDefault(c, 0) +1);
           }
           PriorityQueue<Character> pq = new PriorityQueue<>((a, b)-> map.get(b) - map.get(a)); //desc order of count
           pq.addAll(map.keySet());

           StringBuilder sb = new StringBuilder();
           while(pq.size() > 1) {
             char firstItem = pq.poll();
             char secondItem = pq.poll();

             sb.append(firstItem);
             sb.append(secondItem);
             map.put(firstItem, map.get(firstItem) -1);
             map.put(secondItem, map.get(secondItem) -1);

             if (map.get(firstItem) >0) {
                 pq.add(firstItem);
             }

               if (map.get(secondItem) >0) {
                   pq.add(secondItem);
               }
           }

           if (!pq.isEmpty()) {
               char lastItem = pq.poll();
               if(map.get(lastItem) > 1) {
                   return "";
               }
               sb.append(lastItem);
           }
           return sb.toString();
    }
}
