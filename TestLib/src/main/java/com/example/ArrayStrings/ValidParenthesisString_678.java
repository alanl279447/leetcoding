package com.example.ArrayStrings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesisString_678 {

//    Input: "()"
//    Output: True
//    Input: "(*))"
//    Output: True
//    https://leetcode.com/problems/valid-parenthesis-string/
//   **()), )*()
    public static void main(String[] args) {
//        System.out.println(checkValidStringTest("(**))"));
        System.out.println(checkValidString("(((()"));
    }

    // (((()
    public static boolean checkValidStringTest(String s) {
       int leftWild = 0;

       //check if two many closing tokens
       for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) ==')') {
               if (leftWild ==0) return false;
               leftWild--;
           } else {
               leftWild++;
           }
       }

       //check for too many opening tokens
       int left = 0;
       for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i)=='(') {
               left++;
           } else {
               left = Math.max(0, left-1);
           }
       }
      return left ==0;
    }


    public static boolean checkValidStringTwoPass(String s) {
        int leftWild =0;

        //check for too many right tokens
        for (int i=0; i < s.length();i++) {
            if(s.charAt(i)==')') {
                if (leftWild==0) return false;
                else leftWild--;
            } else {
                leftWild++;
            }
        }

        int left = 0;
        //check for too many left tokens
        for (int i=0; i < s.length();i++) {
            if (s.charAt(i)=='(') {
                left++;
            } else {
                left = Math.max(0, left-1);
            }
        }
        return left ==0;
    }



    public static boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

}
