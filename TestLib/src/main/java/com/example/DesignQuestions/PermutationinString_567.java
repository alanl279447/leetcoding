package com.example.DesignQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class PermutationinString_567 {

//    Input: s1 = "ab" s2 = "eidbaooo"
//    Output: True
//    Explanation: s2 contains one permutation of s1 ("ba").
//    https://leetcode.com/problems/permutation-in-string/
//Time complexity : O(l_1+26*(l_2-l_1)) Space complexity : O(1)

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i=0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length()-s1.length(); i++) {
            if (matchFound(s1Map, s2Map)) {
                return true;
            }
            s2Map[s2.charAt(i)-'a']--;
            s2Map[s2.charAt(i+s1.length()) -'a']++;
        }
        return matchFound(s1Map, s2Map);

    }

    public static boolean matchFound(int[] s1Map, int[] s2Map) {
        for (int i =0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}
