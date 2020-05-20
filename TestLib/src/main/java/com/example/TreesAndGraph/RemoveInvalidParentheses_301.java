package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_301 {

//    Input: "()())()"
//    Output: ["()()()", "(())()"]

//    Input: "(a)())()"
//    Output: ["(a)()()", "(a())()"]
//    https://leetcode.com/problems/remove-invalid-parentheses/
//   Time complexity 0(2^N).

    public static List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        List<String> result = removeInvalidParentheses("()())()");
        for (String res: result) {
            System.out.println(res);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
//        removeHelper(s, output, 0, 0, '(', ')');
        if (s.length() ==0) {
            return output;
        }
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public static void removeHelper(String s, List<String> output, int iStart, int jStart, char openPren, char closedParen) {
        int openParenCount = 0, closeParenCount = 0;
        for (int i = iStart; i < s.length(); i ++) {
         char c = s.charAt(i);
         if (c == openPren) openParenCount++;
         if (c == closedParen) closeParenCount++;

         if (closeParenCount > openParenCount) {
             for (int j = jStart; j < i; j++) {
                 if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j-1) != closedParen)) {
                     removeHelper(s.substring(0, j) + s.substring(j+1, s.length()), output, i, j, openPren, closedParen);
                 }
             }
             return;
         }
        }

        String reverseString = new StringBuilder(s).reverse().toString();
        if (openPren == '(') {
            removeHelper(reverseString, output, 0,0, closedParen, openPren);
        } else {
            output.add(reverseString);
        }

    }


}
