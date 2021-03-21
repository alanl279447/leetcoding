package com.example.ArrayStrings;

public class MinimumWindowSubstring_285 {

//    Input: S = "ADOBECODEBANC", T = "ABC"
//    Output: "BANC"

    public static void main(String[] args) {
//        String input = "ADOBECODEBANC";
        String input = "ADOBANCZ";
        String T = "ABC";
        String result = minWindow(input, T);
        System.out.print(result);
    }

    public static String minWindow(String input, String T) {
        if (T.length() > input.length()) {
            return "";
        }
        int[] map = new int[128];
        char[] Tchars = T.toCharArray();
        for (char c: Tchars) {
            map[c]++;
        }
        int start = 0, end =0, minStart=0, len =Integer.MAX_VALUE, counter=T.length();
        while(end < input.length()) {
            char c = input.charAt(end);
            if(map[c]>0) counter--;
            map[c]--;
            end++;

            while(counter ==0) {
                if (len > end-start) {
                    len = end-start;
                    minStart = start;
                }
                char b = input.charAt(start);
                map[b]++;
                if (map[b] >0) counter++;
                start++;
            }
        }
        return len == Integer.MAX_VALUE ? "":input.substring(minStart, minStart+len);
    }

    public static String minWindowWork(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}