package com.example.ArrayStrings;

//        Input: "(1+(4+5+2)-3)+(6+8)"
//        Output: 23
//        https://leetcode.com/problems/basic-calculator/
//       https://leetcode.com/problems/basic-calculator-iii/discuss/344371/Java-Common-template-for-Basic-Calculator-I-II-and-III-using-Stack

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator_224 {

    public static void main(String[] args) {
        System.out.println(calculateIterative(" 2-1-(6+8) "));
    }

    public static int calculateIterative(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop();
                result = result + stack.pop();
            }
        }
        return result;
    }

    public static int calculateGeneric(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = 0;
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                   sum =  sum * 10 + s.charAt(i+1)-'0';
                }
                num = sum;
            } else if (c == '(') {
                int j = i+1;
                int braces = 1;
                while (j < s.length()) {
                    if (s.charAt(j)== ')') braces--;
                    else if (s.charAt(j) == '(') braces++;
                    j++;
                    if (braces == 0) break;
                }
                num = calculateGeneric(s.substring(i+1, j));
            }

            if (c =='+' || c =='-' || i == s.length()-1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }



    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = 10 * num + (int) (current - '0');
            } else if (current == '(') {
                int j = i + 1;
                int braces = 1;
                for (; j < n; j++) {
                    if (s.charAt(j) == '(') ++braces;
                    if (s.charAt(j) == ')') --braces;
                    if (braces == 0) break;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }

            if (current == '+' || current == '-' || i == n - 1) { // i == n-1, makes sure the last number is added to the stack.
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                num = 0;
                sign = current;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }
}