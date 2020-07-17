package com.example.ArrayStrings;

//        Input: " 3+5 / 2 "
//        Output: 5
//        https://leetcode.com/problems/basic-calculator-ii/

public class BasicCalculatorII_227 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(calculate(" 3+5/2 "));
//        System.out.println(calculate(" 3-2 "));
    }


    public static int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();

        long prevNum = 0;
        int sum = 0;
        char prevOp = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                int val = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    val = val * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (prevOp == '+') {
                    sum += prevNum;
                    prevNum = val;
                } else if (prevOp == '-') {
                    sum += prevNum;
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val;
                } else if (prevOp == '/') {
                    prevNum = prevNum/val;
                }
            } else {
                prevOp = c;
            }
        }
        sum += prevNum;
        return sum;
    }
}