package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation_784 {
//    Examples:
//    Input: S = "a1b2"
//    Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//    Input: S = "3z4"
//    Output: ["3z4", "3Z4"]
//
//    Input: S = "12345"
//    Output: ["12345"]
//    https://leetcode.com/problems/letter-case-permutation/

    public static void main(String args[]) {

        List<String> result = letterCasePermutation("a1b2");
        for(String res: result) {
            System.out.println(res);
        }
    }

    public static List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        return new LinkedList<>(queue);
    }
}