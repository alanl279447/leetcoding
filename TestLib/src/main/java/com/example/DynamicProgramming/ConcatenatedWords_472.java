package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenatedWords_472 {

//    Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
//
//    Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//
//    Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
// "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
//    https://leetcode.com/problems/concatenated-words/
//   O(N * L^2)

    public static void main(String[] args) {
        String[] prices = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog",
                "hippopotamuses", "rat", "ratcatdogcat"};
//        String[] prices = {"cat", "cats", "catsdogcats", "dog"};
        List<String> result =  findAllConcatenatedWordsInADict(prices);
        for (String res:result) {
            System.out.println(res);
        }
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (isConcatenated(set, word)) {
                ret.add(word);
            }
        }
        return ret;
    }

    private static boolean isConcatenated(Set<String> set, String s) {
            for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                String rightStr = s.substring(i);
                if (set.contains(rightStr) || isConcatenated(set, rightStr)) {
                    set.add(s);
                    return true;
                }
            }
        }
        return false;
    }
}