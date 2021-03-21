package com.example.ArrayStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSortString_791 {

//    Example :
//    Input:
//    S = "cba"
//    T = "abcd"
//    Output: "cbad"
//    Explanation:
//            "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
//    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
//    https://leetcode.com/problems/custom-sort-string/

    public static void main(String args[]) {
        String res = customSortString("cba", "abcd");
        System.out.println(res);
    }

    //int[] count 1,1,1,1,0,0,...0 (based on T)
    //string  c,b,a,d
    public static String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];
        }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // group chars in T but not in S.
        }
        return sb.toString();
    }
}