package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AddBoldTaginString_616 {

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

        //Input: A = [2,7,4], K = 181
        //Output: [4,5,5]
        //Explanation: 274 + 181 = 455
//        int[] A = {2,7,4};
//        System.out.println(addToArrayForm(A, 181));
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

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}