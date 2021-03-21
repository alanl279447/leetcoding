package com.example.ArrayStrings;

public class BackspaceStringCompare_844 {

//    Input: S = "ab#c", T = "ad#c"
//    Output: true
//    Explanation: Both S and T become "ac".
//    Can you solve it in O(N) time and O(1) space?
//    https://leetcode.com/problems/backspace-string-compare/

    public static void main(String[] args) {
        String s = "ab#c", T="ad#c";
        //S = "bxj##tw"; T = "bxj###tw";
        System.out.println(backspaceCompare(s, T));
    }

    /**
     - Start from back to front
     - if count > 0 && !#, skip
     - if count == 0 && different, return false
     - if #, count++
     - if one ends, the other count == 0 && has any char return false
     - else return true
     */

    public static boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int i = S.length() - 1, j =  T.length() - 1;
        int cnt1 = 0, cnt2 = 0;//number of '#';
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i) == '#') cnt1++;
                else cnt1--;
                i--;
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j) == '#') cnt2++;
                else cnt2--;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }
}