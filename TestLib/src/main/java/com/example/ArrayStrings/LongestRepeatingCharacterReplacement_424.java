package com.example.ArrayStrings;

public class LongestRepeatingCharacterReplacement_424 {
//    Input: s = "ABAB", k = 2
//    Output: 4
//    Explanation:Replace the two 'A's with two 'B's or vice versa.
//    https://leetcode.com/problems/longest-repeating-character-replacement/

    public static void main(String[] args) {
//        String input = "ADOBECODEBANC";
        String input = "ABAB";
        int K = 2;
        int result = characterReplacement(input, 2);
        System.out.print(result);
    }

    //end-start+1 -- window size
    // maxcount -- count of the single max character
    // end-start+1)-count[c-'A'] > k that implies there is K other characters
    // xxxyz,  k =1, srink window to xxyz
    public static int characterReplacement(String s, int k) {
        int start =0, end = 0, len =0;
        int[] count = new int[26];
        if (s == null || s.length() ==0) return len;

        while (end < s.length()) {
            char c = s.charAt(end);
            ++count[c-'A'];
            end++;
            while ((end-start+1)-count[c-'A'] > k) {
               char c1 = s.charAt(start);
               count[c1-'A']--;
               start++;
            }
          len = Math.max(len, end-start+1);
        }
        return len;
    }
}
