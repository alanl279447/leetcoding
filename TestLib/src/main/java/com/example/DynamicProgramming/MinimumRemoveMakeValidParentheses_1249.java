package com.example.DynamicProgramming;

public class MinimumRemoveMakeValidParentheses_1249 {
//    Input: s = "lee(t(c)o)de)"
//    Output: "lee(t(c)o)de"
//    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
//    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

    public static void main(String[] args) {
        String result = minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(result);
    }

//lee(t(c)o)de)"
//stringBuilder temp   lee(t(c)o)de
//openParan 1,2 , 1, 0    //closed paren
// i = len && openParen > 0   remove open paren
//return sb

    public static String minRemoveToMakeValid(String input) {
        int openParen = 0;
        int length = input.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <length; i++) {
            char c = input.charAt(i);
            if (c == '(') {
                openParen++;
            } else if (c == ')') {
                if(openParen == 0) continue;
                openParen--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i >=0; i--) {
            if (sb.charAt(i) == '(' && openParen-- > 0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}