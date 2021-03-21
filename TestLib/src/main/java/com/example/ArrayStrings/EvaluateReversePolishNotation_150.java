package com.example.ArrayStrings;

//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//        Output: 22
//        Explanation:
//        ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//        = ((10 * (6 / (12 * -11))) + 17) + 5
//        = 22
//        https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        String[] A = {"10", "6", "9", "3", "+", "11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(A));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 3) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            char operator = token.charAt(0);
            if (Character.isDigit(operator)) {
                stack.offer(Integer.parseInt(token));
            } else {
                int temp =0;
                if (stack.size()>=2) {
                    switch (operator) {
                        case '+':
                            temp = stack.poll() + stack.poll();
                            break;
                        case '-':
                            int b = stack.poll();
                            temp =  stack.poll() - b;
                            break;
                        case '/':
                            int b1 = stack.poll();
                            temp = stack.poll() / b1;

                            break;
                        case '*':
                            temp = stack.poll() * stack.poll();
                            break;
                    }
                    stack.offer(temp);
                }
            }
        }
        return !stack.isEmpty()? stack.poll():0;
    }
}