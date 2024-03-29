package com.example.ArrayStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/sentence-similarity/
//        Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
//        Output: true
//        Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.

public class SentenceSimilarity_734 {
    public static void main(String[] args) {
        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> similarPairs = Arrays.asList(Arrays.asList("great","fine"),
                Arrays.asList("drama","acting"),Arrays.asList("skills","talent"));
        System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    public static boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair: pairs) {
            map.putIfAbsent(pair.get(0), new HashSet<>());
            map.putIfAbsent(pair.get(1), new HashSet<>());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for (int i =0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;

            if (!map.containsKey(words1[i])) return false;
            if (!map.get(words1[i]).contains(words2[i])) return false;
        }
        return true;
    }
}