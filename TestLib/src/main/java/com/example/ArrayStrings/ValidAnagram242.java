package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram242 {

//    Input: s = "anagram", t = "nagaram"
//    Output: true
//    https://leetcode.com/problems/valid-anagram/

    public static void main(String[] args) {
        boolean groupAnagrams = isAnagram("anagram", "nagaram");
        System.out.println(groupAnagrams);
    }

    public static boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) return false;

        int[] map = new int[26];
        char[] Tchars = t.toCharArray();
        for (char c: Tchars) {
            map[c-'a']++;
        }

        int start = 0, end = s.length(), counter = t.length();
        while(start < end) {
            char c = s.charAt(start);
            if (map[c-'a'] > 0) counter--;
            map[c-'a']--;
            start++;
        }
        return counter==0? true:false;
    }
}
