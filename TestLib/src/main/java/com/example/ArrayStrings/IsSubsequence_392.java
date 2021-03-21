package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    Input: s = "abc", t = "ahbgdc"
//    Output: true
//    https://leetcode.com/problems/is-subsequence/
public class IsSubsequence_392 {
    public static void main(String[] args) {
        String s = "abcxyz123";
        String[] dict = {"abc","123"};
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequenceTest(String s, String t) {
      Map<Character, List<Integer>> map = new HashMap();
      for (int i=0; i<s.length(); i++) {
          map.putIfAbsent(s.charAt(i), new ArrayList<>());
          map.get(s.charAt(i)).add(i);
      }
      int currentIndex = -1;
      boolean isMatch = false;
      for (int i=0; i< t.length();i++) {
          if (!map.containsKey(t.charAt(i))) {
              return false;
          }
          List<Integer> items = map.get(t.charAt(i));
          for (Integer item: items) {
              if(item > currentIndex) {
                  isMatch=true;
                  currentIndex=item;
              }
          }
          if (!isMatch) return false;
      }
      return true;
    }



    public static boolean isSubsequence(String s, String t) {
        // precomputation, build the hashmap out of the target string
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            if (letterIndicesTable.containsKey(t.charAt(i)))
                letterIndicesTable.get(t.charAt(i)).add(i);
            else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }
        Integer currMatchIndex = -1;
        for (char letter : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter))
                return false; // no match, early exist
            boolean isMatched = false;
            // greedy match with linear search
            for (Integer matchIndex : letterIndicesTable.get(letter)) {
                if (currMatchIndex < matchIndex) {
                    currMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }
            if (!isMatched)
                return false;
        }
        // consume all characters in the source string
        return true;
    }
}