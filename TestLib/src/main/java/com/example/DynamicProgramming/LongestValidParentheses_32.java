package com.example.DynamicProgramming;

import java.util.Stack;

public class LongestValidParentheses_32 {
//    Input: "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()"
//
//    Input: ")()())"
//    Output: 4
//    Explanation: The longest valid parentheses substring is "()()"
//
//    https://leetcode.com/problems/longest-valid-parentheses/

    public static void main(String[] args) {
        int result = longestValidParentheses("())((())");
//        int result = longestValidParentheses("())()");
        System.out.println(result);
    }

    //        ())((())
    // stack  2, 3,
    // ans = 1-(-1) = 2,  6-4 = 2, 7-3 = 4

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}