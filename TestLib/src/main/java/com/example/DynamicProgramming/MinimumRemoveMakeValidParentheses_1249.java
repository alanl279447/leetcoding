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

    public static String minRemoveToMakeValid(String input) {

        int openParen = 0, closeParen = 0;
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

//    public static String minRemoveToMakeValid(String s) {
//        if (s.length() == 0) {
//            return s;
//        }
//        int open = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i=0;i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                open++;
//            }
//            if (c == ')') {
//                if (open ==0) continue;
//                open--;
//            }
//             sb.append(c);
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = sb.length()-1; i >= 0; i--) {
//            if (sb.charAt(i) == '(' && open-->0) continue;
//            result.append(sb.charAt(i));
//        }
//        return result.reverse().toString();
//    }

}
