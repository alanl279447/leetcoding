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



//    public static boolean isPalindrome(String s) {
////        boolean result = false;
//        int length = s.length();
//        int i = 0, j = length-1;
//        char[] sChars = s.toCharArray();
//
//        while (i < length && j >= 0 && i < j) outer : {
//            while (!Character.isLetterOrDigit(sChars[i])) {
//                i++;
//                if (i ==length) break outer;
//            }
//            while (!Character.isLetterOrDigit(sChars[j])) {
//                j--;
//                if (j ==0) break outer;
//            }
//            if (Character.toLowerCase(sChars[i]) != Character.toLowerCase(sChars[j])) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
}
