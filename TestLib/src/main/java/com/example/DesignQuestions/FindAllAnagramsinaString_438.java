package com.example.DesignQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString_438 {

//    Input:
//    s: "cbaebabacd" p: "abc"
//
//    Output:
//            [0, 6]
//
//    Explanation:
//    The substring with start index = 0 is "cba", which is an anagram of "abc".
//    The substring with start index = 6 is "bac", which is an anagram of "abc".
//    https://leetcode.com/problems/find-all-anagrams-in-a-string/

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
//        String s1 = "baa";
//        String s2 = "aa";
        List<Integer> result = findAnagrams(s1, s2);
        for (int res: result)
          System.out.println(res);
    }

    public static List<Integer> findAnagrams(String input, String T) {
        List<Integer> result = new ArrayList<>();
        if (T.length() > input.length()) return result;
        int[] Tchars = new int[26];
        for (int i =0; i < T.length(); i++) {
            Tchars[T.charAt(i) -'a']++;
        }

        int start =0, end=0, counter = T.length();
        while(end < input.length()) {
            char c = input.charAt(end);
            if(Tchars[c-'a'] > 0) counter--;
            Tchars[c-'a']--;
            end++;

            while(counter ==0) {
                if (end-start == T.length()) {
                    result.add(start);
                }
                char b = input.charAt(start);
                Tchars[b-'a']++;
                if (Tchars[b-'a'] > 0) counter++;
                start++;
            }
        }
        return result;
    }
}