package com.example.ArrayStrings;

import java.util.Arrays;

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {

//    Input:s = "ababbc", k = 2
//    Output:5
//    The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
//    https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

    public static void main(String[] args) {
//        String input = "ababbc";
        int result = longestSubstring("aaabbccc", 3);
        System.out.print(result);
    }

//    https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/
    public static int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    static int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++) {
            countMap[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) {
                midNext++;
            }
            return Math.max(longestSubstringUtil(s, start, mid, k), longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }
}