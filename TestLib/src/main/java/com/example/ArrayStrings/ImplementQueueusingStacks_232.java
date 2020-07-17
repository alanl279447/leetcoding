package com.example.ArrayStrings;

public class ImplementQueueusingStacks_232 {

//    Input:
//    s = "abcxyz123"
//    dict = ["abc","123"]
//    Output:"<b>abc</b>xyz<b>123</b>"
//    https://leetcode.com/problems/add-bold-tag-in-string/
//O(N*k)
    public static void main(String[] args) {
        String s = "abcxyz123";
        String[] dict = {"abc","123"};
        System.out.println(addBoldTag(s, dict));
    }

    public static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) {
                j++;
            }
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return result.toString();
    }

}
