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
    //time complexity 0(n^2)..


    public static void main(String[] args) {
//        List<String> wordDict = Arrays.asList("leet", "code");
        List<String> wordDict = Arrays.asList("Cat", "Cats", "Sand", "And", "Dog");
        System.out.print(wordBreak("CatsAndDog", wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
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
