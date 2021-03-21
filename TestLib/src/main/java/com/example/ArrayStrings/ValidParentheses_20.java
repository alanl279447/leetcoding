package com.example.ArrayStrings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses_20 {
//    Input: "([)]"
//    Output: false
//
//    Input: "()[]{}"
//    Output: true
//    https://leetcode.com/problems/valid-parentheses/

    public static void main(String[] args) {
//        String input = "()[]{}";
//        String input = "([)]";
        String input = "([}}])";
        System.out.println(isValidTest(input));
    }

    public static boolean isValidTest(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
       if (s.length() == 0) return true;
        if (s.length() %2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (c == '(' || c =='[' || c =='{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek()=='(') {
                stack.pop();
            }else if (c == ']' && !stack.isEmpty() && stack.peek()=='[') {
                stack.pop();
            }else if (c == '}' && !stack.isEmpty() && stack.peek()=='{') {
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
