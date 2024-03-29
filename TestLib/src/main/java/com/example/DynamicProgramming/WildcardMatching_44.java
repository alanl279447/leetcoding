package com.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching_44 {

//    Input:
//    s = "adceb"
//    p = "*a*b"
//    Output: true
//    Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
//    https://leetcode.com/problems/wildcard-matching/


    //T[i][j] = T[i-1][j-1]   when str[i] == pt[j] || pattern[j]== ?
    //        = T[i-1][j]  || T[i][j-1]  if pattern == '*'
    //        = false

    public static void main(String[] args) {
        String s = "adceb";
        String p = "**a*b";
        System.out.println(isMatch(s,p));
    }


    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][writeIndex];

    }
}
