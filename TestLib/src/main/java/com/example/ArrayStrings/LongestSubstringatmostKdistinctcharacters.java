package com.example.ArrayStrings;

public class LongestSubstringatmostKdistinctcharacters {

//    Input: s = "eceba", k = 2
//    Output: 3
//    Explanation: T is "ece" which its length is 3.
//    https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

    public static void main(String[] args) {
//        String input = "ADOBECODEBANC";
        String input = "eceeeba";
        int K = 2;
        int result = lengthOfLongestSubstringKDistinct(input, K);
        System.out.print(result);
    }

    private static int lengthOfLongestSubstringKDistinct(String input, int K) {
        if (input == null || input.length() < K) {
            return 0;
        }
        int start = 0, end = 0, counter =0, len = 0;
        int[] map = new int[26];
        while(end < input.length()) {
         char c = input.charAt(end);
         if(map[c-'a'] ==0) counter++;
         map[c-'a']++;
         end++;
          while(counter > K) {
              char b = input.charAt(start);
              if(map[b-'a'] == 1) counter--;
              map[b-'a']--;
              start++;
          }
          len = Math.max(len, end-start);
        }
        return len;
    }
}