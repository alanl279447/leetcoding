package com.example.ArrayStrings;

//Input: s = "2*(5+5*2)/3+(6/2+8)"
//        Output: 21
//        https://leetcode.com/problems/basic-calculator-iii/
//https://leetcode.com/problems/basic-calculator-iii/discuss/344371/Java-Common-template-for-Basic-Calculator-I-II-and-III-using-Stack

import java.util.Stack;

public class BasicCalculatorIII_772 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
//        System.out.println(calculate(" 3-2 "));
    }

    public static int calculate(String s) {
         int result = 0;
         if (s== null) return result;
         Stack<Integer> stack = new Stack<>();

         int num =0;
         char sign = '+';
         int n = s.length();
         for (int i=0; i<n; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num += num*10+current-'0';
            } else if (current == '(') {
                int j=i+1;
                int braces =1;
                for (; j<n;j++) {
                   if(s.charAt(j)==')') braces++;
                   else if (s.charAt(j)=='(') braces--;
                   if (braces==0) break;
                }
                num = calculate(s.substring(i+1, j));
                i=j;
            }

             if (current == '+' || current == '-' || current == '*' || current == '/' || i == n - 1) {
                 switch (sign) {
                     case '+':
                         stack.push(num);
                         break;
                     case '-':
                         stack.push(-num);
                         break;
                     case '*':
                         stack.push(stack.pop() * num);
                         break;
                     case '/':
                         stack.push(stack.pop() / num);
                         break;
                 }
                 num = 0;
                 sign = current;
             }
         }
        while(!stack.isEmpty()) result += stack.pop();
        return result;
         }
}