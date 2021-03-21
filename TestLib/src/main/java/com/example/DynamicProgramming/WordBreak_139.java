package com.example.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak_139 {

//    Input: s = "leetcode", wordDict = ["leet", "code"]
//    Output: true
//    Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//    Input: s = "applepenapple", wordDict = ["apple", "pen"]
//    Output: true
//    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//    Note that you are allowed to reuse a dictionary word.
//    https://leetcode.com/problems/word-break/
//O(n^2) because there are O(n) suffixes (i.e. nodes/states in your graph), and when processing each suffix, you have an O(n) for-loop that's looking up prefixes in O(1) time.
//    Now, if you consider .substring() to take O(n) time, then each lookup takes O(n) time because you have to make the substring first.
//    Hence, a more precise total is O(n^3).

    public static void main(String[] args) {
//        List<String> wordDict = Arrays.asList("leet", "code");
//        List<String> wordDict = Arrays.asList("Cat", "Cats", "Sand", "And", "Dog");
        System.out.print(wordBreak("CatsAndDog", Arrays.asList("Cat", "Cats", "Sand", "And", "Dog")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            String s1 = s.substring(start);
            if (visited[start] == 0) {
                for (String di: wordDict) {
                    if (s1.startsWith(di)) {
                        queue.add(start+di.length());
                        if (start+di.length() >= s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    //BFS For every starting index, the search can continue till the end of the given string.
    public static boolean wordBreakOld(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Set<String> notPossible=new HashSet();
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
