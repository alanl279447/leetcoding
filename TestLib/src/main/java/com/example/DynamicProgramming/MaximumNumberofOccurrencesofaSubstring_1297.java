package com.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofOccurrencesofaSubstring_1297 {

//    Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//    Output: 2
//    Explanation: Substring "aab" has 2 ocurrences in the original string.
//    It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
//    https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

    public static void main(String[] args) {
        System.out.print(maxFreq("aabcabcab", 2,2,4));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0, n = s.length();
        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        int count = 0; //count diff character in array
        for (int i = 0; i < n - minSize + 1; i++) {
            String sub = s.substring(i, i + minSize);
            if (i == 0) {
                for (char c : sub.toCharArray()) {
                    arr[c - 'a']++;
                    if (arr[c - 'a'] == 1) count++;
                }
            } else {
                int l = s.charAt(i - 1) - 'a';
                int r = sub.charAt(minSize - 1) - 'a';
                arr[l]--;
                if (arr[l] == 0) count--;
                arr[r]++;
                if (arr[r] == 1) count++;
            }

            if (count > maxLetters) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            res = Math.max(res, map.get(sub));
        }
        return res;
    }
}
