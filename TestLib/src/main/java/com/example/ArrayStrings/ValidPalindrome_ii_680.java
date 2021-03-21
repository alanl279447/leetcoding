package com.example.ArrayStrings;

//        Input: "abca"
//        Output: True
//        Explanation: You could delete the character 'c'.
//        https://leetcode.com/problems/valid-palindrome-ii/

public class ValidPalindrome_ii_680 {

    public static void main(String[] args) {
        String input = "abca";
        System.out.println("Palindrome result:  " + isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
      boolean result = false;
      int length = s.length();
      int i = 0, j = length-1;
      char[] sChars = s.toCharArray();
      int count =0;

      while(i<j) {
          if (sChars[i] != sChars[j]) {
              return isHelperPalindrome(s, i+1, j) || isHelperPalindrome(s, i, j-1);
          }
          i++;
          j--;
      }
      return true;
    }

    public static boolean isHelperPalindrome(String s, int start, int end) {

        while(start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}