package com.example.ArrayStrings;

//        Example:
//        Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//        Input: word1 = “coding”, word2 = “practice”
//        Output: 3
//        https://leetcode.com/problems/shortest-word-distance-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII_244 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        WordDistance obj = new WordDistance(words);
        int param_1 = obj.shortest("makes", "coding");
        System.out.println(param_1);
    }

    static class WordDistance {

        Map<String, List<Integer>> map = new HashMap<>();
        public WordDistance(String[] words) {
            for (int i=0; i < words.length; i++) {
                map.putIfAbsent(words[i], new ArrayList<Integer>());
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
          List<Integer> list1 = map.get(word1), list2 = map.get(word2);
          int res = Integer.MAX_VALUE;
          for (int i=0, j = 0; i < list1.size() && j < list2.size();) {
              int index1 = list1.get(i), index2 = list2.get(j);
              res = Math.min(res, Math.abs(index1-index2));
              if (index1 < index2) {
                  i++;
              } else {
                  j++;
              }
          }
          return res;
        }
    }

}