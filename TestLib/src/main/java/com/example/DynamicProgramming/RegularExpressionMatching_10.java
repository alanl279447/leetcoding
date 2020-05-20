package com.example.DynamicProgramming;

import javax.swing.JTextArea;

public class RegularExpressionMatching_10 {
//    Input:
//    s = "aa"
//    p = "a"
//    Output: false
//    Explanation: "a" does not match the entire string "aa".
//
//    Input:
//    s = "aab"
//    p = "c*a*b"
//    Output: true
//    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//
//    https://leetcode.com/problems/regular-expression-matching/

    public static void main(String[] args) {
        //int[][] nums1 = {{1,3}, {-2,2}};
        System.out.print(isMatch("caab", "c*a*b"));

    }

//    i - index in Txt
//    j - index in the pattern
//
//    str[i]==pattern[j] || pattern[j]=='.' {
//        t[i][j] == t[i-1][j-1];
//    }
//
//    pattern[j] ==*
//  t[i][j] ==   T[i][j-2] = 0 occurance
//  t[i][j] ==   T[i-1][j]     only if str[i] = pattern[j-1] or pattern[j-1] = '.'



    public static boolean isMatch(String s, String p) {

        if (s.length() == 0 && p.length() ==0) {
            return true;
        }
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] T = new boolean[s.length()+1][p.length()+1];

        T[0][0] = true;
        for (int i=1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i-2];
            }
        }

        for (int i = 1; i < T.length; i ++) {
            for (int j=1; j < T[0].length; j++) {
                if(pattern[j-1] == '.' || pattern[j-1]==text[i-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    T[i][j] = T[i][j-2];
                    if (pattern[j-2] == '.' || text[i-1] == pattern[j-2]) {
                        T[i][j] = T[i][j] | T[i-1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[s.length()][p.length()];
    }


}
