package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class WordBreak_II_140 {
//    Input:
//    s = "catsanddog"
//    wordDict = ["cat", "cats", "and", "sand", "dog"]
//    Output:
//            [
//            "cats and dog",
//            "cat sand dog"
//            ]
//
//    Input:
//    s = "pineapplepenapple"
//    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//    Output:
//            [
//            "pine apple pen apple",
//            "pineapple pen apple",
//            "pine applepen apple"
//            ]
//    Explanation: Note that you are allowed to reuse a dictionary word.
//
//    https://leetcode.com/problems/word-break-ii/
//   s O(n * 2^n) (Time and memory).
//    https://salonikaurone.medium.com/leetcode-word-break-ii-explained-d41ecfbe8fc5

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = wordBreak("catsanddog", wordDict);

//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa");
//        List<String> result = wordBreak("aaaa", wordDict);

        for (String res: result) {
            System.out.println(res);
        }
    }

//    s = "pineapplepenapple"
//    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]

    //map for the string and List<String>
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s,wordDict,new HashMap<String, List<String>>());
    }

    // backtrack returns an array including all substrings derived from s.
    public static List<String> DFS(String s, List<String> wordDict, Map<String,List<String>> mem){
        if(mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> result = new ArrayList<String>();
        for(String word: wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) {
                    result.add(word);
                } else {
                    List<String> subs = DFS(next, wordDict, mem);
                    for (String sub : subs) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        mem.put(s, result);
        return result;
    }
}
