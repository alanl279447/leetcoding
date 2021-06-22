package com.example.ArrayStrings;

//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//        https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/288/

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: saPanama";
//        String input2 =  "race a car";
//        String input = ".,";
        System.out.println("Palindrome result:  " + isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length-1;

        while(left < right) {
          while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
              left++;
          }
          while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
              right--;
          }
          if (Character.toLowerCase(s.charAt(left))== Character.toLowerCase(s.charAt(right))) {
              left++;
              right--;
          } else {
              return false;
          }
        }
        return true;
    }
}