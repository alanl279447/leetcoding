package com.example.ArrayStrings;

public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {

//    Input: "eceba"
//    Output: 3
//    Explanation: t is "ece" which its length is 3.
//    https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

    public static void main(String[] args) {
//        String input = "ADOBECODEBANC";
        String input = "eceeba";
        int K = 2;
        int result = lengthOfLongestSubstringTwoDistinctPrac(input);
        System.out.print(result);
    }

    //eceeba
    public static int lengthOfLongestSubstringTwoDistinctPrac(String input) {
        int[] map = new int[128];
        int start=0, end=0, counter=0, maxLength = Integer.MIN_VALUE;
        while (end<input.length()) {
            char a = input.charAt(end);
            if (map[a] == 0) {
                counter++;
            }
            map[a]++;
            end++;
            while (counter>2) {
                char b = input.charAt(start);
                if (map[b]==1) {
                    counter--;
                }
                map[b]--;
               start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;
        int length = s.length();

        if (s.length() ==0) return 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
