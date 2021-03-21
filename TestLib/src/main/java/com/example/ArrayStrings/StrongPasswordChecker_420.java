package com.example.ArrayStrings;

public class StrongPasswordChecker_420 {

//    https://leetcode.com/problems/strong-password-checker/
//    A password is considered strong if below conditions are all met:
//    It has at least 6 characters and at most 20 characters.
//    It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
//    It must NOT contain three repeating characters in a row ("...aaa..." is weak,
//    but "...aa...a..." is strong, assuming other conditions are met).
    public static void main(String[] args) {
        String s = "abC123";
        System.out.println(strongPasswordChecker(s));
    }

    public static int strongPasswordChecker(String s) {
        boolean isLengthCheck = false;
        boolean isUpperCaseCheck = false;
        boolean isLowerCaseCheck = false;
        boolean isDigitCheck = false;
        int result = 0;
        if (s == null) {
            return 6;
        }

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) isLengthCheck=true;
            else if(Character.isUpperCase(c)) isUpperCaseCheck=true;
            else if (Character.isDigit(c)) isDigitCheck=true;
        }
      return 0;
    }
}