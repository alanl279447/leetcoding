package com.example.ArrayStrings;

import java.util.HashSet;
import java.util.Set;

public class NumberofMatchingSubsequences_792 {

//    Example :
//    Input:
//    S = "abcde"
//    words = ["a", "bb", "acd", "ace"]
//    Output: 3
//    Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
//    https://leetcode.com/problems/number-of-matching-subsequences/

    public static void main(String args[]) {
        String[] words = {"a", "bb", "acd", "ace"};
        int res = numMatchingSubseq("abcde", words);
        System.out.println(res);
    }

    //partial!!!
    public static int numMatchingSubseq(String S, String[] words) {
        int result = 0, len = S.length();
        int[] visited = new int[len];
        Set<String> wordSet = new HashSet();
        for (String word: words) {
            wordSet.add(word);
        }

//        for (int start=1; start < len; start++) {
//            if (visited[start] == 0) {
//                 for (int end = start+1; end < len; end++) {
//                     wordSet.contains()
//
//                }
//            }
//        }


        return result;
    }
}
