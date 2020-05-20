package com.example.ArrayStrings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII_1209 {

//    Input: s = "deeedbbcccbdaa", k = 3
//    Output: "aa"
//    Explanation:
//    First delete "eee" and "ccc", get "ddbbbdaa"
//    Then delete "bbb", get "dddaa"
//    Finally delete "ddd", get "aa"
//    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

    public static void main(String args[]) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        String res = removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println(res);
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }

}
