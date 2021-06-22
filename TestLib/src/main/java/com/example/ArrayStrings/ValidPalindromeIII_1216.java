package com.example.ArrayStrings;

//Input: s = "abcdeca", k = 2
//        Output: true
//        Explanation: Remove 'b' and 'e' characters.
//https://leetcode.com/problems/valid-palindrome-iii/
//check Longest_Palindromic_Subsequence_516

public class ValidPalindromeIII_1216 {
    public static void main(String[] args) {
        System.out.println("Valid Palindrome result:  " + isValidPalindrome("abcdeca", 2));
    }

    //find the longest palindrome subSequence
    //len -llps <= k return true else false
    public static boolean isValidPalindrome(String s, int k) {
       int len = s.length();
       int[][] dp = new int[len][len];

       //len1
       for (int i=0;i<len;i++) {
           dp[i][i]=1;
       }

       //len2
        for (int i=0, j=1; j <len; j++,i++) {
            dp[i][j] = s.charAt(i)==s.charAt(j)?2:1;
        }

        //len3
        for (int len3=3; len3<=len;len3++) {
            for (int i=0, j = len3-1; j < len; i++,j++) {
                int max = Math.max(dp[i][j-1], dp[i+1][j]);
                if (s.charAt(i)== s.charAt(j)) {
                    max = Math.max(max, 2+dp[i+1][j-1]);
                }
                dp[i][j]=max;
            }
        }
        return len - dp[0][len-1] <= k;
    }

}
