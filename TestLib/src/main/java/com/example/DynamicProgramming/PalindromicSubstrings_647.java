package com.example.DynamicProgramming;

public class PalindromicSubstrings_647 {
//    Input: "aaa"
//    Output: 6
//    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//    Input: "abc"
//    Output: 3
//    Explanation: Three palindromic strings: "a", "b", "c".
//    https://leetcode.com/problems/palindromic-substrings/
//    https://leetcode.com/problems/palindromic-substrings/discuss/105749/Java-O(n2)-DP-solution
//    time complexity 0(n^2)

    public static void main(String[] args) {
        System.out.print(countSubstrings("aaa"));
    }
        static int count = 0;
        public static int countSubstrings(String s) {
            if (s == null || s.length() == 0) return 0;

            for (int i = 0; i < s.length(); i++) { // i is the mid point
                extendPalindrome(s, i, i); // odd length;
                extendPalindrome(s, i, i + 1); // even length
            }
            return count;
        }

        private static void extendPalindrome(String s, int left, int right) {
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
}