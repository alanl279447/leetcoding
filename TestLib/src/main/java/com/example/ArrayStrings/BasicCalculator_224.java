package com.example.ArrayStrings;

//        Input: "(1+(4+5+2)-3)+(6+8)"
//        Output: 23
//        https://leetcode.com/problems/basic-calculator/

import java.util.Stack;

public class BasicCalculator_224 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(calculate(" 2-1 + 2+(6+8) "));
    }

    public static int calculatePrac(String s) {
      if (s == null || s.length() == 0) {
          return 0;
      }
      int result = 0, sign = 1;
      Stack<Integer> stack = new Stack<>();

      for (int i=0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (Character.isDigit(c)) {
              int val = c -'0';
              while (i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                  val = val * 10 + s.charAt(i+1)-'0';
                  i++;
              }
              result +=val * sign;
          } else if (c == '+') {
              sign = 1;
          } else if (c == '-') {
              sign = -1;
          } else if (c == '(') {
              stack.push(result);
              stack.push(sign);
              result=0;
              sign=1;
          } else if (c == ')') {
              result = result * stack.pop() + stack.pop();
          }
      }
      return result;
    }

    public static int calculate(String s) {
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
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

}