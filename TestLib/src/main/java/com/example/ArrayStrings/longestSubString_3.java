package com.example.ArrayStrings;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class longestSubString_3 {

    public static void main(String[] args) {
        System.out.println("Longest subString is: "+lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        int[] map = new int[128];
        int start = 0, end = 0, len = 0, counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map[c]++;
            if (map[c] > 1) counter++;
            end++;

            while (counter > 0) {
                char b = s.charAt(start);
                if (map[b] > 1) counter--;
                map[b]--;
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}