package com.example.ArrayStrings;

public class PalindromeNumber_9 {

//    Input: -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//   https://leetcode.com/problems/palindrome-number/

    public static void main(String[] args) {

        int number = 12121;
        System.out.println(isPalindrome(number));
    }

    public static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        //negative numbers and no with zero is not palindrome
        if (number < 0 || number%10 ==0 && number != 0) {
            return false;
        }
        while(number > reversedNumber) {
            reversedNumber = reversedNumber * 10 + number %10;
            number = number/10;
        }
        return number==reversedNumber || number == reversedNumber/10;
    }

}
